package com.fun.d2fun.model;

import com.fun.d2fun.common.BaseModel;
import com.fun.d2fun.entity.HeroSimpleInfo;
import com.fun.d2fun.service.HeroService;

import java.util.LinkedHashMap;
import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public class HeroInfoModel extends BaseModel {
    public Flowable<HeroSimpleInfo> getHeroInfo(Map<String,Object> map) {
        return HeroInfoModel.create(HeroService.class).getHeroInfo(map);
    }
}
