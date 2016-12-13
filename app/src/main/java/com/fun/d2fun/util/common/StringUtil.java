package com.fun.d2fun.util.common;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public class StringUtil {
    public static boolean checkEmpty(String string) {
        boolean bool;
        if (string != null
                && !"".equals(string.trim())) {
            bool = false;
        } else {
            bool = true;
        }
        return bool;
    }

    public static boolean characterChinese(char c) {
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(c);
        return ((unicodeBlock != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS)
                && (unicodeBlock != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS)
                && (unicodeBlock != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A)
                && (unicodeBlock != Character.UnicodeBlock.GENERAL_PUNCTUATION)
                && (unicodeBlock != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) && (unicodeBlock != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS));
    }

    /**
     * 手机号码检验
     *
     * @param mobiles
     * @return
     */
    public static boolean checkMobileNO(String mobiles) {
        // Pattern p = Pattern
        // .compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        //
        // Matcher m = p.matcher(mobiles);
        Pattern p = Pattern
                .compile("^1\\d{10}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static String getLastwords(String srcText, String p) {
        try {
            String[] array = TextUtils.split(srcText, p);
            int index = (array.length - 1 < 0) ? 0 : array.length - 1;
            return array[index];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 验证固话
     *
     * @param phone
     * @return
     */
    public static boolean checkTellPhone(String phone) {
        Pattern p = Pattern
                .compile("(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * @param number
     * @return
     */
    public static Date getDateAfterAdd(int number) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(format.parse(getDateAndTime(1)));
            c.add(c.DATE, number);
            newDate = c.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }

    /**
     * 获取时间 0:yyyy-MM-dd HH:mm:ss 1:yyyy-MM-dd 2:HH:mm:ss
     *
     * @return
     */
    public static String getDateAndTime(int type) {
        String date = "";
        String format = "";
        switch (type) {
            case 0:
                format = "yyyy-MM-dd HH:mm:ss";
                break;
            case 1:
                format = "yyyy-MM-dd";
                break;
            case 2:
                format = "HH:mm:ss";

                break;
            case 3:
                format = "MM-dd";
                break;
        }
        try {
            SimpleDateFormat sDateFormat = new SimpleDateFormat(format);
            date = sDateFormat.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 删除号码中的所有非数字
     *
     * @param str
     * @return
     */
    public static String filterUnNumber(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("+86")) {
            str = str.substring(3, str.length());
        }

//		if (str.contains("#")) {
//
//			return str.replaceAll("#", "@");
//		}

        // 只允数字
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        // 替换与模式匹配的所有字符（即非数字的字符将被""替换）
        // 对voip造成的负数号码，做处理
        if (str.startsWith("-")) {
            return "-" + m.replaceAll("").trim();
        } else {
            return m.replaceAll("").trim();
        }

    }

    public static final String PHONE_PREFIX = "+86";

    /**
     * 去除+86
     *
     * @param phoneNumber
     * @return
     */
    public static String formatPhone(String phoneNumber) {
        if (phoneNumber == null) {
            return "";
        }
        if (phoneNumber.startsWith(PHONE_PREFIX)) {
            return phoneNumber.substring(PHONE_PREFIX.length()).trim();
        }
        return phoneNumber.trim();
    }

    private static MessageDigest md = null;

    public static String md5(final String c) {
        if (md == null) {
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        if (md != null) {
            md.update(c.getBytes());
            return byte2hex(md.digest());
        }
        return "";
    }

    public static String byte2hex(byte b[]) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xff);
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = (new StringBuffer(String.valueOf(hs))).toString();
        }

        return hs.toUpperCase();
    }

    /**
     * 将集合转换成字符串，用特殊字符做分隔符
     *
     * @param srcList   转换前集合
     * @param separator 分隔符
     * @return
     */
    public static String listToString(List<String> srcList, String separator) {
        if (srcList == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < srcList.size(); ++i)
            if (i == srcList.size() - 1) {
                sb.append(((String) srcList.get(i)).trim());
            } else {
                sb.append(((String) srcList.get(i)).trim() + separator);
            }
        return sb.toString();
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字符串转换成整型，如果为空则返回默认值
     *
     * @param str 字符串
     * @param def 默认值
     * @return
     */
    public static int getInt(String str, int def) {
        try {
            if (str == null) {
                return def;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return def;
    }

    public static String weekToString(int i) {
        switch (i) {
            case Calendar.MONDAY:
                return "一";
            case Calendar.TUESDAY:
                return "二";
            case Calendar.WEDNESDAY:
                return "三";
            case Calendar.THURSDAY:
                return "四";
            case Calendar.FRIDAY:
                return "五";
            case Calendar.SATURDAY:
                return "六";
            case Calendar.SUNDAY:
                return "日";
        }
        return null;
    }

    /**
     * 距离换算
     *
     * @param distance 千米级
     * @return
     */
    public static String distance(double distance) {
        if ((int) distance > 0) {
            return String.format("%1$.2f", distance) + "千米";
        } else {
            return ((long) (new BigDecimal(distance).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue() * 1000)) + "米";
        }
    }
}
