package com.fun.d2fun.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by zx on 2016/1/20.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HeroDetailsInfo implements Serializable {
    private String hero_name; //英雄的名称
    private String hero_atk; //英雄的攻击力
    private float hero_atk_up; //英雄的攻击成长
    private float hero_def; //英雄的初始防御
    private int hero_spd;   //英雄的移动速度
    private int hero_pow;   //英雄的力量
    private int hero_agi;   //英雄的敏捷
    private int hero_int;   //英雄的智力
    private int hero_atk_range; //英雄的攻击范围
    private int hero_ball;  //英雄的弹道速度
    private float hero_pow_up;  //英雄的力量成长
    private float hero_int_up;  //英雄的智力成长
    private float hero_agi_up;  //英雄的敏捷成长
    private String hero_view;   //英雄的视野范围
    private int hero_atk_type;  //英雄的攻击类型
    private String hero_alias;  //英雄的别名
    private String hero_pos;    //英雄的定位
    private int hero_type;  //英雄的主要属性
    private String hero_story;  //英雄的背景故事
    private int hero_atk_spd;   //英雄的攻击速度
    private String hero_def_res;    //英雄的魔法防御

}
