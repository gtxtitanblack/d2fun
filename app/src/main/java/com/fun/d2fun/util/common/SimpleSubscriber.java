package com.fun.d2fun.util.common;

import com.orhanobut.logger.Logger;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by ZX on 2016/11/25 0025.
 * Info: 简化 Rx 的模式,用在只关乎 onNext() 逻辑
 */

public abstract class SimpleSubscriber<T> extends ResourceSubscriber<T> {
    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        Logger.t(e.toString());
    }
}
