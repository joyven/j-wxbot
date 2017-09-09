package com.joyven.wxbot.common.qrcode;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.ServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/8
 * Time: 下午10:02
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
@Component
public class GenerateQrCode {
    public void genQrCode(InputStream in, ServletResponse response) throws IOException {
        BufferedImage bi = ImageIO.read(in);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", bos);
        bos.close();
        in.close();
        response.getOutputStream().write(bos.toByteArray());
    }
}
