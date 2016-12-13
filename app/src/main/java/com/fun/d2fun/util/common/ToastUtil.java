package com.fun.d2fun.util.common;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zx on 2016/7/29.
 */

public class ToastUtil {
    private static String oldMsg;
    protected static Toast toast = null;

    /**
     * @param context 上下文
     * @param text    显示内容
     */
    public static void show(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            oldMsg = text;
            toast.setText(text);
            toast.show();
        }
    }

    public static void show(Context context, int resId) {
        show(context, context.getString(resId));
    }
}
