package com.joyven.wxbot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.WriterException;
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
        Map<String,Object> map = wxBotService.getUuid()
        return wxBotService.genQrCode((String) map.get("uuid"));
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Object login() {
        LOGGER.info("开始登录微信客户端：{}", System.currentTimeMillis());
        Map<String, Object> map = wxBotService.getUuid();
        if (map == null || map.size() == 0) {
            LOGGER.error("获取微信uuid失败");
        }
        String image = wxBotService.genQrCode(map.get("uuid"));


    }

}
