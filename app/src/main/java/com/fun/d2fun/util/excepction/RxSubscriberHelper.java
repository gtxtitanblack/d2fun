package com.fun.d2fun.util.excepction;


import com.fun.d2fun.common.AppApplication;
import com.fun.d2fun.util.NetConnectionUtils;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by ZX on 2016/11/17 0017.
 */

public abstract class RxSubscriberHelper<T> extends ResourceSubscriber<T> {

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (!NetConnectionUtils.isNetworkConnected(AppApplication.getInstance().getApplicationContext())) {
            _onError("当前网络不可用，请稍候再试");
        } else if (e instanceof ServerException) {
            _onError(e.getMessage());
        } else {
            _onError("请求失败,请稍后再试....");
        }
    }

    @Override
    public void onComplete() {

    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);
}
