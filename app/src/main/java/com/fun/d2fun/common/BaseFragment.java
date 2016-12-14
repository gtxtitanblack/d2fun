package com.fun.d2fun.common;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fun.d2fun.util.DialogUtil;
import com.fun.d2fun.view.BaseView;

import java.util.LinkedHashMap;

import butterknife.ButterKnife;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public abstract class BaseFragment<V extends BaseView, T extends BasePersenter<V>> extends Fragment {
    public Context context;
    public Resources res;
    public AppApplication mAppApplication;
    public View mLayoutView;
    public T presenter;
    //在基类中初始化Dialog
    public Dialog mLoading;
    private BaseActivity mBaseActivity;
    public LinkedHashMap<String, Object> mParmMap = new LinkedHashMap<>();


    public BaseFragment() {
        super();
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        res = context.getResources();
        mAppApplication = AppApplication.getInstance();
        /**从给定的context中获得LayoutInflater*/
//        mInflater = LayoutInflater.from(getActivity());
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach((V) this);
        }
        mLoading = DialogUtil.createLoadingDialog(getActivity());
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {
            initView();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mLayoutView != null) {
            ViewGroup parent = (ViewGroup) mLayoutView.getParent();
            if (parent != null) {
                parent.removeView(mLayoutView);
            }
        } else {
            mLayoutView = getCreateView(inflater, container);
            ButterKnife.bind(this, mLayoutView);
            initView();     //初始化布局
        }
        return mLayoutView;
    }


    /**
     * 获取Fragment布局文件的View
     *
     * @param inflater
     * @param container
     * @return
     */
    private View getCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettach();
        }
//        RefWatcher refWatcher = AppApplication.getRefWatcher(getActivity());
//        refWatcher.watch(this);
    }

    public BaseActivity getBaseActivity() {
        if (mBaseActivity == null) {
            mBaseActivity = (BaseActivity) getActivity();
        }
        return mBaseActivity;
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    public abstract T initPresenter();

    /**
     * 加载数据操作,在视图创建之前初始化
     */
    public abstract void initView();

    public abstract int getLayoutRes();
}