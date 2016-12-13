package com.fun.d2fun.util.common;


import java.io.IOException;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 添加固定三个参数的拦截器
 */
public class AddQueryParameterInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request request;
        String method = originalRequest.method();
        Headers headers = originalRequest.headers();
        HttpUrl.Builder builder = originalRequest.url().newBuilder();
        // Provide your custom parameter here
//        if (MyApplication.getInstance().getLoginResultBean()!=null){
//            builder.addQueryParameter("hxid",MyApplication.getInstance().getLoginResultBean().getData().getHxid())
//                    .addQueryParameter("acesstoken",MyApplication.getInstance().getLoginResultBean().getAcesstoken()).addQueryParameter("ver",Constants.VER_VALUE);
//        }
        HttpUrl modifiedUrl= builder.build();
        request = originalRequest.newBuilder().url(modifiedUrl).build();
        return chain.proceed(request);
    }
}
