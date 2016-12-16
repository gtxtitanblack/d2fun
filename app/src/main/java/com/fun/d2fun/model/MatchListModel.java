package com.fun.d2fun.model;

import com.fun.d2fun.entity.HeroSimpleInfo;
import com.fun.d2fun.entity.MatchListInfo;
import com.fun.d2fun.service.HeroService;
import com.fun.d2fun.service.MatchListService;

import java.util.LinkedHashMap;
import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by ZX on 2016/12/15 0015.
 */

public class MatchListModel {
    public Flowable<MatchListInfo.ResultEntity.LeaguesEntity> getMatchList(Map<String, Object> map) {
        return HeroInfoModel.create(MatchListService.class).getMatchListInfo(map);
    }
}
