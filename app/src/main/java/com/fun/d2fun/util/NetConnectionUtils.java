package com.fun.d2fun.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.fun.d2fun.util.common.ToastUtil;


/**
 * Created by ZX on 2016/11/15 0015.、
 */

public class NetConnectionUtils {

    // 判断网络连接状态
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager
                .getActiveNetworkInfo();
        if (mNetworkInfo != null) {
            if (mNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                ToastUtil.show(context, "This is" + mNetworkInfo.getTypeName());
            } else if (mNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                ToastUtil.show(context, "当前是移动网络，请注意流量哦");
            }
            return mNetworkInfo.isAvailable();
        }
        return false;
    }
}
