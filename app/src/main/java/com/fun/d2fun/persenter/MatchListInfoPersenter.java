package com.fun.d2fun.persenter;

import com.fun.d2fun.R;
import com.fun.d2fun.common.BasePersenter;
import com.fun.d2fun.entity.MatchListInfo;
import com.fun.d2fun.model.HeroInfoModel;
import com.fun.d2fun.model.MatchListModel;
import com.fun.d2fun.util.common.SimpleSubscriber;
import com.fun.d2fun.util.excepction.RxSubscriberHelper;
import com.fun.d2fun.view.MatchListInfoView;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZX on 2016/12/15 0015.
 */

public class MatchListInfoPersenter extends BasePersenter<MatchListInfoView> {
    private MatchListModel mMatchListModel;

    public MatchListInfoPersenter() {
        this.mMatchListModel = new MatchListModel();
    }

    public void getMatchListInfo(Map<String, Object> map, PullLoadMoreRecyclerView pullLoadMoreRecyclerView) {
        mMatchListModel.getMatchList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleSubscriber<MatchListInfo.ResultEntity.LeaguesEntity>() {
                    @Override
                    public void onNext(MatchListInfo.ResultEntity.LeaguesEntity leaguesEntity) {
                        mView.getMatchList(leaguesEntity);
                        pullLoadMoreRecyclerView.setLinearLayout();
                        pullLoadMoreRecyclerView.setColorSchemeResources(R.color.blue, android.R.color.holo_blue_bright, R.color.light_blue);
                        pullLoadMoreRecyclerView.setPushRefreshEnable(false);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
                    }
                });
    }
}
