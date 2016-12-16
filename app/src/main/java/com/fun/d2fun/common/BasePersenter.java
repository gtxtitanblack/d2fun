package com.fun.d2fun.common;

import com.fun.d2fun.util.common.StringUtil;
import com.fun.d2fun.view.BaseView;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public abstract class BasePersenter<T extends BaseView> {
    public T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void dettach() {
        mView = null;
    }

    //错误时的操作
    public void showError(String error) {
        if (mView != null) {
            mView.hideLoading();
            mView.showError(error);
        }
    }



    public boolean isEmpty(String string) {
        if (StringUtil.checkEmpty(string)) {
            mView.showError("数据为空");
            return true;
        }
        return false;
    }
}