package com.joyven.wxbot.util;

import java.util.Random;

/**
 * Created by zjw on 2017/9/5.
 */
public class TimeUtils {
    public static long getTimestamp() {
        return System.currentTimeMillis() + (new Random().nextInt()) * 998 + 1;
    }
}
