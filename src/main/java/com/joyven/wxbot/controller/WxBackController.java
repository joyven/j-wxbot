package com.joyven.wxbot.controller;

import com.google.zxing.WriterException;
import com.joyven.wxbot.pojo.WxUuid;
import com.joyven.wxbot.service.WxBotService;
import com.joyven.wxbot.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/8
 * Time: 上午9:06
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
@Controller
@RequestMapping("wx/back")
public class WxBackController {
    private final static Logger LOGGER = LoggerFactory.getLogger(WxBackController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Joyven");
        return "hello";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("qrcode", "/wxbot/portal/index");
        return "index";
    }

}
