package com.joyven.wxbot.service;

import com.google.zxing.WriterException;
import com.joyven.wxbot.config.QrCodeConfig;
import com.joyven.wxbot.config.UUIDConfig;
import com.joyven.wxbot.http.HttpsClient;
import com.joyven.wxbot.http.RestHttpsClient;
import com.joyven.wxbot.pojo.WxUuid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WxBotService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxBotService.class);
    private static final ThreadLocal<String> local = new ThreadLocal<>();
    @Resource
    private UUIDConfig uuidConfig;
    @Resource
    private QrCodeConfig qrCodeConfig;

    public Map<String, Object> getUuid() {
        LOGGER.info("开始获取微信UUID，appid:{}", uuidConfig.getAppid());
        Map<String, String> body = new HashMap<>();
        body.put("appid", uuidConfig.getAppid());
        body.put("fun", uuidConfig.getFun());
        body.put("lang", uuidConfig.getLang());
        body.put("_", String.valueOf(new Date().getTime() + (new Random().nextInt(998) + 1)));

        String result = RestHttpsClient.postFormUrlEncode(uuidConfig.getWxJsLoginUrl(), body);
        WxUuid wxUuid = null;
        if (result != null) {
            String regEx = "window.QRLogin.code = (\\d+); window.QRLogin.uuid = \"(\\S+?)\";";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(result.trim());
            if (matcher.matches()) {
                matcher.reset();
                while (matcher.find()) {
                    String code = matcher.group(1);
                    String uuid = matcher.group(2);
                    wxUuid = new WxUuid();
                    wxUuid.setCode(code);
                    wxUuid.setUuid(uuid);
                    local.set(uuid);
                    LOGGER.info("code: {}, uuid: {}", code, uuid);
                }
            }
        }
        return wxUuid;
    }

    public String genQrCode(String uuid) throws WriterException, IOException {
        String url = qrCodeConfig.getQrCodeUrl();
        String imagePath = qrCodeConfig.getImagePath();
        if (imagePath == null || "".equals(imagePath)) {
            imagePath = System.getProperty("user.home");
        }
        if (imagePath.lastIndexOf("/") < 0) {
            imagePath = imagePath + File.separator;
        }
        FileOutputStream fos;
        try {
            InputStream inputStream = HttpsClient.get(url + uuid).asStream();
            File file = new File(imagePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            fos = new FileOutputStream(imagePath + qrCodeConfig.getImageName());
            byte[] data = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(data)) != -1) {
                fos.write(data, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath + qrCodeConfig.getImageName();
    }


}
