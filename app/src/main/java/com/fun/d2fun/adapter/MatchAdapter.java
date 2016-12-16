package com.fun.d2fun.adapter;

import android.content.Context;

import com.fun.d2fun.entity.MatchListInfo;
import com.fun.d2fun.weiget.recycleview.CommonAdapter;
import com.fun.d2fun.weiget.recycleview.base.ViewHolder;

import java.util.List;

/**
 * Created by ZX on 2016/12/15 0015.
 */

public class MatchAdapter extends CommonAdapter<MatchListInfo> {
    public MatchAdapter(Context context, int layoutId, List<MatchListInfo> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, MatchListInfo matchListInfo, int position) {

    }
}
