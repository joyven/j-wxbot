package com.joyven.wxbot.config.wx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zjw on 2017/9/5.
 */
@ConfigurationProperties(prefix = "wx")
@Component
public class WaitLoginByScanQrCodeConfig {

    @Value("${wx.mmweb.bin.login}")
    private String mmWebWxBinLogin;

    @Value("${wx.mmweb.bin.tip}")
    private Integer tip;

    public String getMmWebWxBinLogin() {
        return mmWebWxBinLogin;
    }

    public void setMmWebWxBinLogin(String mmWebWxBinLogin) {
        this.mmWebWxBinLogin = mmWebWxBinLogin;
    }

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }
}
