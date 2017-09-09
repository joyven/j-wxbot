package com.joyven.wxbot.schedule;

import com.joyven.wxbot.service.WxBotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/8
 * Time: 下午11:05
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class CheckLoginTask implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckLoginTask.class);
    private String uuid;
    @Autowired
    private WxBotService wxBotService;

    public CheckLoginTask(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void run() {
        while (true) {
//            String res = wxBotService.waitForLogin(uuid);
//            if (res != null) {
//                if (res.contains("200")) {
//                    LOGGER.info("登陆成功！");
//                    break;
//                }
//                if (res.contains("408") || res.contains("400")) {
//                    LOGGER.error("登录超时或者异常：{}", res);
//                }
//                if (res.contains("201")) {
//                    LOGGER.info("扫描成功");
//                }
//            }
        }
    }
}
