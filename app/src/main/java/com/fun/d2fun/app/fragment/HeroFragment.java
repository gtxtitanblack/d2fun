package com.fun.d2fun.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fun.d2fun.R;
import com.fun.d2fun.common.BaseFragment;
import com.fun.d2fun.entity.HeroSimpleInfo;
import com.fun.d2fun.persenter.HeroInfoPersenter;
import com.fun.d2fun.view.HeroInfoView;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public class HeroFragment extends BaseFragment<HeroInfoView, HeroInfoPersenter> implements HeroInfoView {
    @Override
    public void initView() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLayoutView = inflater.inflate(R.layout.activity_main, container, false);
        ButterKnife.bind(this, mLayoutView);
        return mLayoutView;
    }

    @Override
    public HeroInfoPersenter initPresenter() {
        return new HeroInfoPersenter();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void getTestInfo(HeroSimpleInfo.ResultEntity.HeroesEntity heroesEntity) {
        Logger.d(heroesEntity);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String error) {
        Snackbar.make(getView(), error, Snackbar.LENGTH_LONG).show();
    }
}
