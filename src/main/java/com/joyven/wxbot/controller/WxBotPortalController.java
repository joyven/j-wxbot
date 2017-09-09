package com.joyven.wxbot.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.WriterException;
import com.joyven.wxbot.common.qrcode.GenerateQrCode;
import com.joyven.wxbot.pojo.WxUuid;
import com.joyven.wxbot.pojo.vo.CheckLoginMessage;
import com.joyven.wxbot.schedule.CheckLoginTask;
import com.joyven.wxbot.service.WxBotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/8
 * Time: 下午9:53
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
@RestController
@RequestMapping("/wxbot/portal")
public class WxBotPortalController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxBotPortalController.class);
    private String uuid;
    private String redirect_url;
    @Autowired
    private GenerateQrCode qrCode;
    @Autowired
    private WxBotService wxBotService;

    @RequestMapping("/index")
    @ResponseBody
    public void index(HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Set-Cookie", "name=value; HttpOnly");
        response.setDateHeader("Expire", 0);
//        // 获取UUID
//        LOGGER.info("开始登录微信客户端：{}", System.currentTimeMillis());
//        WxUuid wxUuid = wxBotService.getUuid();
//        uuid = wxUuid.getUuid();
//
//        if (wxUuid == null || wxUuid.getUuid() == null || "".equals(wxUuid.getUuid().trim())) {
//            LOGGER.error("获取微信uuid失败");
//        }
//
//        // 生成二维码
//        InputStream is = wxBotService.getQrCode(wxUuid.getUuid());
//        qrCode.genQrCode(is, response);
        // 轮训检查是否扫码登录
//        new Thread(new CheckLoginTask(wxUuid.getUuid())).start();
    }

    @RequestMapping(value = "/check/login", produces = MediaType.TEXT_EVENT_STREAM_VALUE + ";charset=utf-8")
    public String checkLogin(HttpServletResponse response) throws IOException {
        String res = wxBotService.waitForLogin(uuid);
        if (res != null) {
            if (res.contains("200")) {
                LOGGER.info("登陆成功！");
                int start = res.indexOf("https");
                redirect_url = res.substring(start).replace("\";", "");
                return getEventSource(200, true);
            }
            if (res.contains("408") || res.contains("400")) {
                LOGGER.error("登录超时或者异常：{}", res);
                return getEventSource(400, false);
            }
            if (res.contains("201")) {
                LOGGER.info("扫描成功");
                return getEventSource(201, false);
            }
        }
        return getEventSource(500, false);
    }

    private String getEventSource(int code, boolean res) {
        return "data:{'res':'" + res + "','code':'" + code + "'}\n\n" +
                "event:message\n\n" +
                "id:" + new Random().nextInt(1000) + "\n\n";
    }

    @MessageMapping("chat")
    @SendTo("queue/check")
    public CheckLoginMessage check(String msg) {
        System.out.println(msg);
        CheckLoginMessage message = new CheckLoginMessage();
        message.setCode(0);
        message.setRes(true);
        message.setMsg("ceshi");

        return message;

    }

}
