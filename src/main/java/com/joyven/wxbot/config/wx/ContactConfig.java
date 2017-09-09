package com.joyven.wxbot.config.wx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/8
 * Time: 下午2:58
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
@ConfigurationProperties(prefix = "wx.contact")
@Component
public class ContactConfig {
    // https://wx.qq.com/cgi-bin/mmwebwx-bin//webwxgetcontact?pass_ticket=xxx&skey=xxx&r=xxx
    @Value("${wx.contact.url}")
    private String wxContactUrl;
    @Value("${wx.contact.batch.url}")
    private String wxBatchContactUrl;


    public String getWxContactUrl() {
        return wxContactUrl;
    }

    public void setWxContactUrl(String wxContactUrl) {
        this.wxContactUrl = wxContactUrl;
    }

    public String getWxBatchContactUrl() {
        return wxBatchContactUrl;
    }

    public void setWxBatchContactUrl(String wxBatchContactUrl) {
        this.wxBatchContactUrl = wxBatchContactUrl;
    }
}
