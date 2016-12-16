package com.fun.d2fun.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fun.d2fun.R;
import com.fun.d2fun.app.fragment.HeroFragment;
import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ZX on 2016/11/15 0015.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
//    @Bind(R.id.home_tab_ico)
//    ImageView mTabIco;
    @Bind(R.id.home_tab_title)
    TextView mTabTitle;
    final int PAGE_COUNT = 5;
    private Context mContext;
    private int mListTitle[] = new int[]{R.string.app_name, R.string.home_hero, R.string.home_item,
            R.string.app_name, R.string.app_name};


    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }


    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_tab, null);
        ButterKnife.bind(this, view);
        mTabTitle.setText(mListTitle[position]);
//        mTabIco.setImageResource(tabIcos[position]);
        //img.setImageResource(imageResId[position]);
        return view;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HeroFragment();
            case 1:
                return new HeroFragment();
            case 2:
                return new HeroFragment();
            case 3:
                return new HeroFragment();
            case 4:
                return new HeroFragment();
        }
        Logger.d("fragmentPagerAdapter load position = " + position);
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitle[position] + "";
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
