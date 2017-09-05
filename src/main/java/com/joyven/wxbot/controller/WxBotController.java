package com.joyven.wxbot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.WriterException;
import com.joyven.wxbot.pojo.WxUuid;
import com.joyven.wxbot.service.WxBotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/4
 * Time: 下午6:06
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
@RestController
@RequestMapping("wxbot")
public class WxBotController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxBotController.class);
    @Resource
    private WxBotService wxBotService;

    @RequestMapping("uuid")
    public Object getUuid() {
        return wxBotService.getUuid();
    }

    @RequestMapping("qrcode")
    public Object genQrCode() throws IOException, WriterException {
        WxUuid wxUuid = wxBotService.getUuid();
        return wxBotService.genQrCode(wxUuid.getUuid());
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Object login() throws IOException {
        // 获取UUID
        LOGGER.info("开始登录微信客户端：{}", System.currentTimeMillis());
        WxUuid wxUuid = wxBotService.getUuid();

        if (wxUuid == null || wxUuid.getUuid() == null || "".equals(wxUuid.getUuid().trim())) {
            LOGGER.error("获取微信uuid失败");
        }

        // 生成二维码
        String image = null;
        try {
            image = wxBotService.genQrCode(wxUuid.getUuid());
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return null;

    }

}
