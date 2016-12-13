package com.fun.d2fun.common;

import android.os.Environment;
import android.text.TextUtils;

import com.fun.d2fun.Config;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public class BaseModel {
    private static Gson gson = new Gson();
    private static Retrofit retrofit;
    private static WeakHashMap<String, Object> cache = new WeakHashMap<>();


    static {
        Interceptor interceptor = chain -> {
            Request request = chain.request();
            Response response = chain.proceed(request);
            String cacheControl = request.cacheControl().toString();
            if (TextUtils.isEmpty(cacheControl)) {
                cacheControl = "public, max-age=60";
            }
            return response.newBuilder()
                    .header("Cache-Control", cacheControl)
                    .removeHeader("Pragma")
                    .build();
        };

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addNetworkInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .cache(new Cache(Environment.getDownloadCacheDirectory(), 20)).build();
//        okHttpClient.setConnectTimeout(3, TimeUnit.SECONDS);
//        okHttpClient.setCache(new Cache(Environment.getDownloadCacheDirectory(), 20));
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Config.BASE_ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static <T> T create(Class<T> service) {
        T t = (T) cache.get(service.getSimpleName());
        if (null == t) {
            t = retrofit.create(service);
            cache.put(service.getSimpleName(), t);
        }
        return t;
    }
}
