package com.chlhrssj.demo.ui.lifecycle;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * Create by rssj on 2019-12-02
 */
public class LifeObserver implements DefaultLifecycleObserver {

    private static final String TAG = "LifeObserver";

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.d(TAG,"onCreate()");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Log.d(TAG,"onStart()");
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        Log.d(TAG,"onResume()");

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Log.d(TAG,"onPause()");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Log.d(TAG,"onStop()");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Log.d(TAG,"onDestroy() ");
    }
}
