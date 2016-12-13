package com.fun.d2fun.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by zx on 2016/2/22.
 */
@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class ItemDetailsInfo implements Serializable {
    private int item_cd;
    private String item_alias;
    private String item_info;//物品背景故事
    private String item_effect;//物品提升的属性
    private String item_intros;//物品效果
    private String item_cost;
    private String item_name;
    private String url;
}
