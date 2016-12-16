package com.fun.d2fun.service;

import com.fun.d2fun.Config;
import com.fun.d2fun.entity.HeroSimpleInfo;
import com.fun.d2fun.entity.MatchListInfo;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by ZX on 2016/12/15 0015.
 */

public interface MatchListService {
    @GET(Config.MATCH_INFO_URL)
    Flowable<MatchListInfo.ResultEntity.LeaguesEntity> getMatchListInfo(@QueryMap Map<String, Object> map);
}
