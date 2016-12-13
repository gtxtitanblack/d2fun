package com.fun.d2fun.view;

import com.fun.d2fun.entity.HeroSimpleInfo;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public interface HeroInfoView extends BaseView {
    void getTestInfo(HeroSimpleInfo.ResultEntity.HeroesEntity heroesEntity);
}
