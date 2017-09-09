package com.joyven.wxbot.config.wx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 上午9:44
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
@ConfigurationProperties(prefix = "wx")
@Component
public class WebWxInitConfig {
    @Value("${wx.web.init.url}")
    private String webWxInitUrl;

    public String getWebWxInitUrl() {
        return webWxInitUrl;
    }

    public void setWebWxInitUrl(String webWxInitUrl) {
        this.webWxInitUrl = webWxInitUrl;
    }
}
