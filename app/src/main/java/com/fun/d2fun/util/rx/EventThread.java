package com.fun.d2fun.util.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZX on 2016/12/6 0006.
 */

public enum EventThread {
    /**
     * 主线程
     */
    MAIN_THREAD,
    /**
     * 新的线程
     */
    NEW_THREAD,
    /**
     * 读写线程
     */
    IO,
    /**
     * 计算工作默认线程
     */
    COMPUTATION,
    /**
     * 在当前线程中按照队列方式执行
     */
    TRAMPOLINE;

    public static Scheduler getScheduler(EventThread threadMode){
        Scheduler scheduler;
        switch (threadMode){
            case MAIN_THREAD:scheduler= AndroidSchedulers.mainThread();break;
            case NEW_THREAD:scheduler= Schedulers.newThread();break;
            case IO:scheduler=Schedulers.io();break;
            case COMPUTATION:scheduler=Schedulers.computation();break;
            case TRAMPOLINE:scheduler=Schedulers.trampoline();break;
            default:scheduler= AndroidSchedulers.mainThread();
        }
        return scheduler;
    }
}
