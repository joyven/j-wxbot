package com.joyven.wxbot.service;

import com.alibaba.fastjson.JSON;
import com.google.zxing.WriterException;
import com.joyven.wxbot.config.wx.ContactConfig;
import com.joyven.wxbot.config.wx.QrCodeConfig;
import com.joyven.wxbot.config.wx.UUIDConfig;
import com.joyven.wxbot.config.wx.WaitLoginByScanQrCodeConfig;
import com.joyven.wxbot.config.wx.WebWxInitConfig;
import com.joyven.wxbot.config.wx.WxMsgConfig;
import com.joyven.wxbot.http.HttpsClient;
import com.joyven.wxbot.http.RestHttpsClient;
import com.joyven.wxbot.message.vo.TextMsg;
import com.joyven.wxbot.pojo.WxContactResponse;
import com.joyven.wxbot.pojo.WxError;
import com.joyven.wxbot.pojo.WxInitBase;
import com.joyven.wxbot.pojo.WxInitResponse;
import com.joyven.wxbot.pojo.WxStatusNofity;
import com.joyven.wxbot.pojo.WxUser;
import com.joyven.wxbot.pojo.WxUuid;
import com.joyven.wxbot.util.NumberUtils;
import com.joyven.wxbot.util.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.joyven.wxbot.http.RestHttpsClient.postJson;
import static com.joyven.wxbot.util.TimeUtils.getTimestamp;
import static com.joyven.wxbot.util.XmlUtils.getObject;

@Service
public class WxBotService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxBotService.class);
    private static final ThreadLocal<String> local = new ThreadLocal<>();
    private static final ThreadLocal<WxError> wxError = new ThreadLocal<>();
    @Resource
    private UUIDConfig uuidConfig;
    @Resource
    private QrCodeConfig qrCodeConfig;
    @Resource
    private WaitLoginByScanQrCodeConfig scanQrCodeConfig;
    @Resource
    private WebWxInitConfig webWxInitConfig;
    @Resource
    private ContactConfig contactConfig;
    @Resource
    private WxMsgConfig wxMsgConfig;

    public WxUuid getUuid() {
        LOGGER.info("开始获取微信UUID，appid:{}", uuidConfig.getAppid());
        Map<String, String> body = new HashMap<>();
        body.put("appid", uuidConfig.getAppid());
        body.put("fun", uuidConfig.getFun());
        body.put("lang", uuidConfig.getLang());
        body.put("_", String.valueOf(new Date().getTime() + (new Random().nextInt(998) + 1)));

        String result = RestHttpsClient.postFormUrlEncode(uuidConfig.getWxJsLoginUrl(), body);
        WxUuid wxUuid = null;
        if (result != null) {
            String regEx = "window.QRLogin.code = (\\d+); window.QRLogin.uuid = \"(\\S+?)\";";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(result.trim());
            if (matcher.matches()) {
                matcher.reset();
                while (matcher.find()) {
                    String code = matcher.group(1);
                    String uuid = matcher.group(2);
                    wxUuid = new WxUuid();
                    wxUuid.setCode(code);
                    wxUuid.setUuid(uuid);
                    local.set(uuid);
                    LOGGER.info("code: {}, uuid: {}", code, uuid);
                }
            }
        }
        return wxUuid;
    }

    public String genQrCode(String uuid) throws WriterException, IOException {
        String url = qrCodeConfig.getQrCodeUrl();
        String imagePath = qrCodeConfig.getImagePath();
        FileOutputStream fos;
        try {
            InputStream inputStream = HttpsClient.get(url + uuid).asStream();
            File file = new File(imagePath);
            if (!file.exists()) file.mkdirs();
            fos = new FileOutputStream(imagePath + qrCodeConfig.getImageName());
            byte[] data = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(data)) != -1) {
                fos.write(data, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath + qrCodeConfig.getImageName();
    }

    public InputStream getQrCode(String uuid) {
        String url = qrCodeConfig.getQrCodeUrl();
        return HttpsClient.get(url + uuid).asStream();

    }

    public String waitForLogin(String uuid) {
        LOGGER.info("等待扫描二维码！");
        String url = scanQrCodeConfig.getMmWebWxBinLogin();
        Integer tip = scanQrCodeConfig.getTip();
        if (tip == null || tip == 0) tip = 1;
        StringBuffer sb = new StringBuffer();
        sb.append(url).append("?")
                .append("tip=").append(tip)
                .append("&uuid=").append(uuid)
                .append("&_").append(getTimestamp());

        return HttpsClient.get(sb.toString()).asString();

    }

    public WxError login(String url) {
        LOGGER.info("开始登录微信，跳转地址：{}", url);
//        String res = HttpsClient.get(url).asString();
        Map<String, Object> headers = new HashMap<>();
        headers.put("Host", "wx.qq.com");
        headers.put("Pragma", "no-cache");
        headers.put("Referer", "https://wx.qq.com/?&lang=zh_CN");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, " +
                "like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        headers.put("Connection", "keep-alive");

        if (!url.contains("fun")) {
            // 一定要注意带上这个参数，如果没有这个参数，则直接打开一个页面
            url = url + "&fun=new";
        }
        String res = null;
        try {
            res = RestHttpsClient.getObject(url, headers, String.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        WxError wxError = getObject(res, WxError.class);
        if (wxError != null) {
            System.out.println(wxError.toString());
        } else {
            LOGGER.error("登录微信出错，获取数据为空");
        }
        return wxError;
    }

    public WxInitResponse init(String passTicket, String skey, WxInitBase requestBase) {
        LOGGER.info("初始化微信客户端...");
        System.out.println("初始化的skey:" + skey);
        String url = webWxInitConfig.getWebWxInitUrl();
        int cap = url.length() + passTicket.length() + skey.length() + 13 + 21 + 11;
        StringBuilder sb = new StringBuilder(cap);
        sb.append(url).append("?pass_ticket=").append(passTicket)
                .append("&skey=").append(skey).append("&r=")
                .append(System.currentTimeMillis()).append("&lang=en_US");
        Map<String, WxInitBase> params = new HashMap<>(2);
        params.put("BaseRequest", requestBase);
        String res = null;
        try {
            res = postJson(sb.toString(), null, params);
            System.out.println(res);
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
        // 解析res
        WxInitResponse response = JSON.parseObject(res, WxInitResponse.class);
        return response;
    }

    /**
     * 开启微信状态通知
     *
     * @param wxError
     * @param initBase
     * @param wxUser
     */
    public void statusNotify(WxError wxError, WxInitBase initBase, WxUser wxUser) {
        String url = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxstatusnotify?lang=zh_CN&pass_ticket=";
        if (wxError == null) {
            throw new RuntimeException("微信状态通知参数错误！");
        }
        url = url + wxError.getPassTicket();

        WxStatusNofity nofity = new WxStatusNofity();
        nofity.setBaseRequest(initBase);
        nofity.setCode(3);
        nofity.setFromUserName(wxUser.getUserNme());
        nofity.setToUserName(wxUser.getUserNme());
        nofity.setClientMsgId(TimeUtils.getTimestamp());
        String res = null;
        try {
            res = postJson(url, null, nofity);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (res != null) {
            System.out.println("通知：" + res);
        }
    }

    /**
     * https://wx.qq.com/cgi-bin/mmwebwx-bin//webwxgetcontact?pass_ticket=xxx&skey=xxx&r=xxx
     *
     * @param passTicket
     * @param skey
     */
    public WxContactResponse getContact(String passTicket, String skey, WxInitBase requestBase) throws MalformedURLException, URISyntaxException {
        String url = contactConfig.getWxContactUrl();
        StringBuilder sb = new StringBuilder();
        sb.append(url).append("?seq=0&lang=zh_CN&pass_ticket=").append(passTicket)
                .append("&skey=").append(skey).append("&r=").append(System.currentTimeMillis());
        url = sb.toString();
        System.out.println(url);
        Map<String, WxInitBase> params = new HashMap<>(2);
        params.put("BaseRequest", requestBase);
        String res = postJson(sb.toString(), null, params);
        System.out.println(res);
        return JSON.parseObject(res, WxContactResponse.class);
    }

    /**
     * 批量获取联系人
     */
    public void batchGetContact() {

    }

    /**
     * 获取群聊成员信息
     */
    public void batchGetGroupContact() {

    }

    /**
     * 发送文本消息
     * @param passTicket 票据
     * @param from 发送者userName
     * @param to 接收者userName
     * @param content 发送内容
     * @param requestBase cookie请求体
     * @throws MalformedURLException
     * @throws URISyntaxException
     */
    public void sendTextMsg(String passTicket, String from, String to, String content, WxInitBase requestBase) throws MalformedURLException, URISyntaxException {
        String url = wxMsgConfig.getWxMsgSendUrl();
        url = url + "?pass_ticket=" + passTicket;
        Map<String, Object> param = new HashMap<>();
        param.put("BaseRequest", requestBase);
        TextMsg msg = new TextMsg();
        msg.setContent(content);
        msg.setFromUserName(from);
        msg.setToUserName(to);
        String msgId = NumberUtils.genMsgId();
        msg.setClientMsgId(msgId);
        msg.setLocalID(msgId);
        param.put("Msg", msg);
        String res = postJson(url, null, param);
        System.out.println(res);
    }

    // 撤回消息
    public boolean revokemsg() {
        // https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxrevokemsg
        return true;
    }

    // 发送表情
    public void sendEmotionMsg() {
        // https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxsendemoticon?fun=sys&f=json&pass_ticket=xxx
    }




}
