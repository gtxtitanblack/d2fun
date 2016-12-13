package com.fun.d2fun.util.common;

import java.text.SimpleDateFormat;

//时间格式化工具
public class TimeFormatUtils {
    public static SimpleDateFormat format;
    public static String getTimeFormat1() {
        format=new SimpleDateFormat("hh:mm:ss");
        return format.format(System.currentTimeMillis());
    }
}
