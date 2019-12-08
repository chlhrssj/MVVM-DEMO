package com.chlhrssj.demo.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.chlhrssj.demo.base.inter.IView;
import com.chlhrssj.demo.util.GenericsUtils;
import com.chlhrssj.demo.util.TUtil;
import com.chlhrssj.demo.util.ToastUtils;

import java.lang.reflect.ParameterizedType;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Create by rssj on 2019-11-29
 */
public abstract class BaseVMActivity<T extends BaseViewModel> extends AppCompatActivity implements IView {

    private Unbinder unBinder;
    protected BaseVMActivity mActivity ;

    protected T mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        mActivity = this ;

        mViewModel = new ViewModelProvider(this).get((Class<T>) TUtil.getInstance(this, 0));

        initView();
        initVM();
    }

    protected Context getContext() {
        return this;
    }

    protected void initVM() {
        mViewModel.getEventLiveData().observe(this, stringBaseEvent -> {
            switch (stringBaseEvent.getWhat()) {
                case BaseViewModel.TOASTMSG:
                    ToastUtils.showShort(MyApplication.getInstance().getApplicationContext(), stringBaseEvent.obj);
            }
        });

        mViewModel.getLoadState().observe(this, baseEvent -> {
            switch (baseEvent.getWhat()) {
                case BaseViewModel.NORMAL:
                    showNormal();
                case BaseViewModel.LOADING:
                    showLoading();
                case BaseViewModel.EMPTY:
                    showEmptyView();
                case BaseViewModel.ERROR: {
                    showError();
                }
            }
        });

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
