package com.fun.d2fun.persenter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;

import com.fun.d2fun.Config;
import com.fun.d2fun.R;
import com.fun.d2fun.adapter.HeroInfoAdapter;
import com.fun.d2fun.common.BasePersenter;
import com.fun.d2fun.common.ConstantParms;
import com.fun.d2fun.entity.HeroSimpleInfo;
import com.fun.d2fun.model.HeroInfoModel;
import com.fun.d2fun.util.ColorSnackbar;
import com.fun.d2fun.util.excepction.RxSubscriberHelper;
import com.fun.d2fun.view.HeroInfoView;
import com.orhanobut.logger.Logger;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.LinkedHashMap;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public class HeroInfoPersenter extends BasePersenter<HeroInfoView> {
    private HeroInfoModel mHeroInfoModel;

    public HeroInfoPersenter() {
        this.mHeroInfoModel = new HeroInfoModel();
    }


    public void getHeroSimpleInfo(LinkedHashMap<String, Object> map, PullLoadMoreRecyclerView pullLoadMoreRecyclerView, Context context) {
        mHeroInfoModel.getHeroInfo(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<HeroSimpleInfo, Publisher<HeroSimpleInfo.ResultEntity.HeroesEntity>>() {
                    @Override
                    public Publisher<HeroSimpleInfo.ResultEntity.HeroesEntity> apply(HeroSimpleInfo heroSimpleInfo) throws Exception {
                        mView.getHeroInfo(heroSimpleInfo.getResult());
                        return Flowable.fromIterable(heroSimpleInfo.getResult().getHeroes());
                    }
                }).subscribe(new ResourceSubscriber<HeroSimpleInfo.ResultEntity.HeroesEntity>() {
            @Override
            public void onNext(HeroSimpleInfo.ResultEntity.HeroesEntity heroesEntity) {
                heroesEntity.setUrl(Config.HERO_IMG_URL + heroesEntity.getName().substring(14) + ConstantParms.fullPic);
                pullLoadMoreRecyclerView.setRefreshing(true);
                pullLoadMoreRecyclerView.setGridLayout(3);
                pullLoadMoreRecyclerView.setItemAnimator(new DefaultItemAnimator());
                pullLoadMoreRecyclerView.setFooterViewText("加载更多数据.....");
                pullLoadMoreRecyclerView.setFooterViewTextColor(R.color.light_blue);
                pullLoadMoreRecyclerView.setFooterViewBackgroundColor(android.R.color.background_light);
                pullLoadMoreRecyclerView.setColorSchemeResources(R.color.blue, android.R.color.holo_blue_bright, R.color.light_blue);
                pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
            }

            @Override
            public void onError(Throwable t) {
                ColorSnackbar.warning(Snackbar.make(pullLoadMoreRecyclerView, "网络故障，请稍候重试", Snackbar.LENGTH_LONG)).show();
            }

            @Override
            public void onComplete() {
            }
        });
    }
}
