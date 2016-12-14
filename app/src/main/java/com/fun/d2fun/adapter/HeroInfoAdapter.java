package com.fun.d2fun.adapter;

import android.content.Context;

import com.fun.d2fun.R;
import com.fun.d2fun.entity.HeroSimpleInfo;
import com.fun.d2fun.util.common.ImageLoader;
import com.fun.d2fun.weiget.recycleview.CommonAdapter;
import com.fun.d2fun.weiget.recycleview.base.ViewHolder;

import java.util.List;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public class HeroInfoAdapter extends CommonAdapter<HeroSimpleInfo.ResultEntity.HeroesEntity> {

    private Context mContext;

    public HeroInfoAdapter(Context context, int layoutId, List<HeroSimpleInfo.ResultEntity.HeroesEntity> datas) {
        super(context, layoutId, datas);
        mContext = context;
    }

    @Override
    protected void convert(ViewHolder holder, HeroSimpleInfo.ResultEntity.HeroesEntity heroesEntity, int position) {
        holder.setText(R.id.hero_name,heroesEntity.getLocalized_name());
        ImageLoader.load(mContext,heroesEntity.getUrl(),holder.getView(R.id.hero_ico));
    }
}
