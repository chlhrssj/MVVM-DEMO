package com.chlhrssj.demo.base;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Create by rssj on 2019-12-03
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);
    }
}
