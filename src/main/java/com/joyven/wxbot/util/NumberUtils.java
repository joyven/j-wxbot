package com.joyven.wxbot.util;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 上午10:57
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class NumberUtils {
    public static String createData(int length) {
        StringBuilder sb = new StringBuilder(16);
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public static String genMsgId() {
        StringBuilder msgId = new StringBuilder(String.valueOf(System.currentTimeMillis()).substring(3));
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            msgId.append(rand.nextInt(10));
        }
        return msgId.toString();
    }
}
