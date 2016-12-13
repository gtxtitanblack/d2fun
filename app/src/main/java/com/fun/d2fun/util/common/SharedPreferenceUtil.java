package com.fun.d2fun.util.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/**
 * Created by ZX on 2016/11/25 0025.
 * SharpePreference的封装
 */

public class SharedPreferenceUtil {
    /**
     * SharedPreference名称
     */
    public static final String PREFERENCE_FILE_NAME = "inke_preferences";

    /**
     * 添加String串到SharedPreference中
     *
     * @param context Context
     * @param key     键
     * @param value   值
     */
    public static void saveString(final Context context, final String key, final String value) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 清除本地所有数据
     *
     * @param context
     */
    public static void clearLocalValues(final Context context) {
        SharedPreferences preference = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor = preference.edit();
        editor.clear();
        editor.commit();
    }

    public static void deleteByKey(final Context context, String key) {
        SharedPreferences preference = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor = preference.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 添加int到SharedPreference中
     *
     * @param context Context
     * @param key     键
     * @param value   值
     */
    public static void saveInt(final Context context, String key, int value) {
        SharedPreferences preference = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor = preference.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * 添加boolean到SharedPreference中
     *
     * @param context Context
     * @param key     键
     * @param value   值
     */
    public static void saveBoolean(final Context context, String key,
                                   Boolean value) {
        SharedPreferences preference = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor = preference.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 获取String
     *
     * @param context
     * @param key     名称
     * @return 键对应的值，如果找不到对应的值， 则返回Null
     */
    public static String getStringValue(final Context context, final String key) {
        SharedPreferences preference = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        return preference.getString(key, null);
    }

    /**
     * 获取Boolean
     *
     * @param context
     * @param key     名称
     * @return 键对应的值，如果找不到对应的值， 则返回false
     */
    public static boolean getBooleanValue(final Context context, final String key) {
        SharedPreferences preference = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        return preference.getBoolean(key, false);
    }

    /**
     * 获取String
     *
     * @param context
     * @param key     名称
     * @return 键对应的值，如果找不到对应的值， 则返回-1
     */
    public static int getIntValue(final Context context, final String key) {
        SharedPreferences preference = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        return preference.getInt(key, -1);
    }

    /**
     * 获取String
     *
     * @param context
     * @param key     名称
     * @return 键对应的值，如果找不到对应的值， 则返回-1
     */
    public static long getLongValue(final Context context, final String key) {
        SharedPreferences preference = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        return preference.getLong(key, -1);
    }

    /**
     * 保存对象
     *
     * @param context
     * @param key
     * @param object
     */
    public static void saveObject(final Context context, String key,
                                  Object object) {
        SharedPreferences preference = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor = preference.edit();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String objectBase64 = new String(Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT));
        editor.putString(key, objectBase64);
        editor.commit();
    }

    /**
     * 获取本地缓存对象
     *
     * @param context
     * @param key
     * @return Object
     */
    public static Object getObject(Context context, String key) {
        SharedPreferences preference = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        String personBase64 = preference.getString(key, "");
        byte[] base64Bytes = Base64.decode(personBase64.getBytes(), 0);
        ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object object = ois.readObject();
            return object;
        } catch (StreamCorruptedException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
