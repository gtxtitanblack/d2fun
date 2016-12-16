package com.fun.d2fun.view;

import com.fun.d2fun.entity.HeroSimpleInfo;
import com.fun.d2fun.entity.MatchListInfo;

/**
 * Created by ZX on 2016/12/15 0015.
 */

public interface MatchListInfoView extends BaseView {
    void getMatchList(MatchListInfo.ResultEntity.LeaguesEntity leaguesEntity);
}
