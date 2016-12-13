package com.fun.d2fun.util.rx;

import android.support.annotation.NonNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ZX on 2016/12/6 0006.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
    @NonNull int tag();

    EventThread thread() default EventThread.MAIN_THREAD;
}