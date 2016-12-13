package com.fun.d2fun.view;

import android.content.Context;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public interface BaseView {

    void showLoading();

    void hideLoading();

    void showError(String error);

    Context getContext();
}
