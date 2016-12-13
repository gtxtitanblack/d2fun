package com.fun.d2fun.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fun.d2fun.R;
import com.fun.d2fun.view.BaseView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public abstract class BaseActivity<V extends BaseView, T extends BasePersenter<V>> extends AppCompatActivity {
    @Bind(R.id.toolbar_titie)
    TextView mTextView;
    @Bind(R.id.home_toolbar)
    Toolbar mToolbar;
    @Bind(R.id.back_btn)
    ImageView mBackBtn;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        ((AppApplication) getApplication()).registerActivity(this);
        initView();
        initPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((AppApplication) getApplication()).unregisterActivity(this);
        ButterKnife.unbind(this);
    }


    public abstract T initPresenter();

    protected abstract void initView();

    protected abstract int getContentView();

    public void setToolbarClick(boolean flag) {
        if (flag) {
            mBackBtn.setVisibility(View.VISIBLE);
            mBackBtn.setOnClickListener(view -> finish());
        } else {
            mBackBtn.setVisibility(View.GONE);
        }
    }

    //设置头部标题
    public void setBarTitleText(String titleText) {
//            imageView.setOnClickListener(v -> finish());
        if (null != mToolbar) {
            mTextView.setText(titleText);
            mToolbar.setTitle(titleText);
//            setSupportActionBar(mToolbar);
        }
    }


    public FragmentManager getBaseFragmentManager() {
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        return fragmentManager;
    }

    /**
     * 获取Fragment事物管理
     *
     * @return
     */
    public FragmentTransaction getFragmentTransaction() {
        return getBaseFragmentManager().beginTransaction();
    }

    /**
     * 替换一个Fragment并设置是否加入回退栈
     *
     * @param res
     * @param fragment
     * @param isAddToBackStack
     */
    public void replaceFragment(int res, BaseFragment fragment, boolean isAddToBackStack) {
        FragmentTransaction fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.replace(res, fragment);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();

    }
}