package com.joyven.wxbot.config.wx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/5
 * Time: 下午2:26
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
@ConfigurationProperties(prefix = "wx")
@Component
public class QrCodeConfig {
    @Value("${wx.qrcode.url}")
    private String qrCodeUrl;
    @Value("${wx.qrcode.image.path}")
    private String imagePath;
    @Value("${wx.qrcode.name}")
    private String imageName = "qrcode.png";

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
