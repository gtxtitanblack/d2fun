package com.fun.d2fun.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fun.d2fun.R;
import com.fun.d2fun.adapter.HeroInfoAdapter;
import com.fun.d2fun.common.BaseFragment;
import com.fun.d2fun.common.ConstantParms;
import com.fun.d2fun.entity.HeroSimpleInfo;
import com.fun.d2fun.persenter.HeroInfoPersenter;
import com.fun.d2fun.util.common.ToastUtil;
import com.fun.d2fun.view.HeroInfoView;
import com.orhanobut.logger.Logger;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public class HeroFragment extends BaseFragment<HeroInfoView, HeroInfoPersenter> implements HeroInfoView {
    @Bind(R.id.hero_recyclerview)
    PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    @Bind(R.id.hero_null_data)
    TextView mTextView;

    private HeroInfoAdapter mHeroInfoAdapter;
    private List<HeroSimpleInfo.ResultEntity.HeroesEntity> mHeroesEntities;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLayoutView = inflater.inflate(R.layout.fragment_heroinfo, container, false);
        ButterKnife.bind(this, mLayoutView);
        return mLayoutView;

    }

    @Override
    public void initView() {
        loadHeroData();
    }

    @Override
    public HeroInfoPersenter initPresenter() {
        return new HeroInfoPersenter();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_heroinfo;
    }


    @Override
    public void showLoading() {
//        mLoading.show();
    }

    @Override
    public void hideLoading() {
        mLoading.hide();
    }

    @Override
    public void showError(String error) {

    }

    @OnClick(R.id.hero_recyclerview)
    public void onClick(View view) {
        ToastUtil.show(getContext(), "asd");
        mTextView.setVisibility(View.GONE);
        loadHeroData();
    }


    @Override
    public void getHeroInfo(HeroSimpleInfo.ResultEntity resultEntity) {
        mHeroesEntities = new ArrayList<>();
        if (resultEntity != null) {
            mHeroesEntities.addAll(resultEntity.getHeroes());
            mHeroInfoAdapter = new HeroInfoAdapter(getContext(), R.layout.item_heroinfo, mHeroesEntities);
            mPullLoadMoreRecyclerView.setAdapter(mHeroInfoAdapter);
            mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
                @Override
                public void onRefresh() {
                    mHeroInfoAdapter.clearData();
                    mHeroInfoAdapter.notifyDataSetChanged();
                    loadHeroData();
                }

                @Override
                public void onLoadMore() {
                    loadHeroData();
                }
            });
        }
    }

    private void loadHeroData() {
        mParmMap.put("key", ConstantParms.steamKey);
        mParmMap.put("language", ConstantParms.parmLanguage);
        presenter.getHeroSimpleInfo(mParmMap, mPullLoadMoreRecyclerView, mTextView);
    }
}
