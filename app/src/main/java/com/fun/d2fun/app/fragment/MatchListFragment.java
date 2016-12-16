package com.fun.d2fun.app.fragment;

import com.fun.d2fun.common.BaseFragment;
import com.fun.d2fun.entity.MatchListInfo;
import com.fun.d2fun.model.MatchListModel;
import com.fun.d2fun.persenter.MatchListInfoPersenter;
import com.fun.d2fun.view.MatchListInfoView;
import com.orhanobut.logger.Logger;

import java.util.Map;

/**
 * Created by ZX on 2016/12/15 0015.
 */

public class MatchListFragment extends BaseFragment<MatchListInfoView, MatchListInfoPersenter> implements MatchListInfoView {
    @Override
    public MatchListInfoPersenter initPresenter() {
        return null;
    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutRes() {
        return 0;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void getMatchList(MatchListInfo.ResultEntity.LeaguesEntity leaguesEntity) {
        Logger.d(leaguesEntity);
    }

    private void getMatchList(Map<String, Object> map) {

    }
}
