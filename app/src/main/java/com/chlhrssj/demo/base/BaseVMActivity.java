package com.chlhrssj.demo.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chlhrssj.demo.base.inter.IView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Create by rssj on 2019-11-29
 */
public abstract class BaseVMActivity extends AppCompatActivity implements IView {

    private Unbinder unBinder;
    public BaseVMActivity mActivity ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);//禁止截屏
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        //setImmeriveStatuBar();
        mActivity = this ;

        initView();
    }

    protected Context getContext() {
        return this;
    }

    protected void startAct(Class c) {
        startActivity(new Intent(this, c));
    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initView();


    @Override
    public void showError(String msg, String code) {

    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showError() {

    }
}
