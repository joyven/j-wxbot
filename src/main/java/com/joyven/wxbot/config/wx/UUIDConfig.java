package com.joyven.wxbot.config.wx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/4
 * Time: 下午6:10
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
@ConfigurationProperties(prefix = "wx")
@Component
public class UUIDConfig {
    @Value("${wx.jslogin.uuid}")
    private String wxJsLoginUrl;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.fun}")
    private String fun;

    @Value("${wx.lang}")
    private String lang;

    public String getWxJsLoginUrl() {
        return wxJsLoginUrl;
    }

    public void setWxJsLoginUrl(String wxJsLoginUrl) {
        this.wxJsLoginUrl = wxJsLoginUrl;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
