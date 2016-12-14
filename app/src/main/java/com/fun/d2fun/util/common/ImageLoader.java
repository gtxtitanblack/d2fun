package com.fun.d2fun.util.common;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by ZX on 2016/11/25 0025.
 * 图片管理类
 */

public class ImageLoader {
    public static void load(Context context, @DrawableRes int imageRes, ImageView view) {
        Glide.with(context).load(imageRes).crossFade().into(view);
    }

    public static void load(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).crossFade().into(imageView);
    }

    public static void clear(Context context) {
        Glide.get(context).clearMemory();
    }
}
