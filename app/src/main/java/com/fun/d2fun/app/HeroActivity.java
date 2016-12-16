package com.fun.d2fun.app;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.fun.d2fun.R;
import com.fun.d2fun.adapter.ViewPagerAdapter;
import com.fun.d2fun.common.BaseActivity;
import com.fun.d2fun.common.BasePersenter;
import com.fun.d2fun.util.common.MultiDexUtils;

import butterknife.Bind;

public class HeroActivity extends BaseActivity {
    @Bind(R.id.home_tabLayout)
    TabLayout mTableLayout;
    @Bind(R.id.home_viewPager)
    ViewPager mViewPager;

    private ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void initView() {
        new MultiDexUtils().getLoadedExternalDexClasses(this);
        setBarTitleText(getString(R.string.app_name));
        setToolbarClick(false);
        initTab();
    }

    private void initTab() {
        mViewPagerAdapter = new ViewPagerAdapter(getBaseFragmentManager(), this);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTableLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < mTableLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTableLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(mViewPagerAdapter.getTabView(i));
            }
        }

        mTableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getCustomView().findViewById(R.id.home_tab_title).setSelected(true);
                switch (tab.getPosition()) {
                    case 0:
                        setBarTitleText(getString(R.string.app_name));
                        break;
                    case 1:
                        setBarTitleText(getString(R.string.home_item));
                        break;
                    case 2:
                        setBarTitleText(getString(R.string.home_hero));
                        break;
                    case 3:
                        setBarTitleText("ASFAFS");
                        break;
                    case 4:
                        setBarTitleText(getString(R.string.app_name));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // 将离开的tab的textView的select属性设置为false
                tab.getCustomView().findViewById(R.id.home_tab_title).setSelected(false);
                // 将viewpager的item与 tablayout的同步
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    protected int getContentView() {
        return R.layout.activity_home_viewpager;
    }


    @Override
    public BasePersenter initPresenter() {
        return null;
    }


}
