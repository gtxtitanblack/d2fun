package com.fun.d2fun.service;

import com.fun.d2fun.Config;
import com.fun.d2fun.entity.HeroSimpleInfo;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public interface HeroService {
    @GET(Config.HERO_URL)
    Flowable<HeroSimpleInfo> getHeroInfo(@QueryMap Map<String, Object> map);
}
