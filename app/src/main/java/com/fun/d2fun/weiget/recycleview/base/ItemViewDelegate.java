package com.fun.d2fun.weiget.recycleview.base;

/**
 * Created by ZX on 2016/11/25 0025.
 */

public interface ItemViewDelegate<T>
{

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}