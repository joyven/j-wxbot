package com.joyven.wxbot.config.wx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/8
 * Time: 下午5:25
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
@ConfigurationProperties(prefix = "wx.msg")
@Component
public class WxMsgConfig {
    @Value("${wx.msg.send.url}")
    private String wxMsgSendUrl;

    public String getWxMsgSendUrl() {
        return wxMsgSendUrl;
    }

    public void setWxMsgSendUrl(String wxMsgSendUrl) {
        this.wxMsgSendUrl = wxMsgSendUrl;
    }
}
