package com.joyven.wxbot.service;

import com.google.zxing.WriterException;
import com.joyven.wxbot.config.QrCodeConfig;
import com.joyven.wxbot.config.UUIDConfig;
import com.joyven.wxbot.config.WaitLoginByScanQrCodeConfig;
import com.joyven.wxbot.http.HttpsClient;
import com.joyven.wxbot.http.RestHttpsClient;
import com.joyven.wxbot.pojo.WxError;
import com.joyven.wxbot.pojo.WxUuid;
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

import static com.joyven.wxbot.util.TimeUtils.getTimestamp;
import static com.joyven.wxbot.util.XmlUtils.getObject;

@Service
public class WxBotService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxBotService.class);
    private static final ThreadLocal<String> local = new ThreadLocal<>();
    @Resource
    private UUIDConfig uuidConfig;
    @Resource
    private QrCodeConfig qrCodeConfig;
    @Resource
    private WaitLoginByScanQrCodeConfig scanQrCodeConfig;

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
        if (imagePath == null || "".equals(imagePath)) {
            imagePath = System.getProperty("user.home");
        }
        if (imagePath.lastIndexOf("/") < 0) {
            imagePath = imagePath + File.separator;
        }
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
        System.out.println(res);
        WxError wxError = getObject(res, WxError.class);
        if (wxError != null) {
            System.out.println(wxError.toString());
        } else {
            LOGGER.error("登录微信出错，获取数据为空");
        }
        return wxError;
    }

    public Object init() {
        LOGGER.info("初始化微信客户端...");
        return null;
    }

}
