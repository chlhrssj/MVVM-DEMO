package com.chlhrssj.demo.ui.lifecycle;

import androidx.annotation.Nullable;

import android.os.Bundle;

import com.chlhrssj.demo.R;
import com.chlhrssj.demo.base.BaseVMActivity;

public class LifecycleActivity extends BaseVMActivity {

    LifeObserver lifeObserver;
    NoLifeObserver noLifeObserver;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lifecycle;
    }

    @Override
    protected void initView() {
        lifeObserver = new LifeObserver();
        getLifecycle().addObserver(lifeObserver);

        noLifeObserver = new NoLifeObserver();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noLifeObserver.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        noLifeObserver.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        noLifeObserver.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        noLifeObserver.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        noLifeObserver.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        noLifeObserver.onDestroy();
    }
}
