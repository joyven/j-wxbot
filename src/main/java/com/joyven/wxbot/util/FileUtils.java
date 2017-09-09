package com.joyven.wxbot.util;

import javax.servlet.ServletContext;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/8
 * Time: 上午10:02
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class FileUtils {
    public static String getQrCodePath(ServletContext context, String path) {
        if (path == null || "".equals(path)) {
            path = context.getContextPath();
        }
        if (path != null && (path.lastIndexOf("/") + 1) < path.length()) {
            path =  path + File.separator;
        }
        return path;
    }
}
