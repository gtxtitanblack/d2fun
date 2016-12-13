package com.fun.d2fun;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public class Config {
    public static final String BASE_ROOT_URL = "https://api.steampowered.com";    //基础请求网址
    public static final String HERO_URL = "/IEconDOTA2_570/GetHeroes/v0001/";//英雄名称列表
    public static final String ITEM_URL = "/IEconDOTA2_570/GetRarities/v1";//列表

    public static final String HERO_IMG_URL = "http://cdn.dota2.com/apps/dota2/images/heroes/";//英雄图片列表
    public static final String ITEM_IMG_URL = "http://cdn.dota2.com.cn/apps/dota2/images/items/";//物品图片列表
    public static final String ITEM_COST_IMG_URL = "http://cdn.dota2.com/apps/dota2/images/tooltips/gold.png";//小金币图标
    public static final String CD_IMG_URL = "http://cdn.dota2.com/apps/dota2/images/tooltips/cooldown.png";//CD图标

    public static final String MATCH_INFO_URL = "/IDOTA2Match_570/GetLeagueListing/v1/";//最近大赛

    public static final boolean DEBUG = Boolean.parseBoolean("true");
    public static final String APPLICATION_ID = "com.fun.d2fun";
    public static final String BUILD_TYPE = "debug";
    public static final String FLAVOR = "";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "1.0.0";
}
