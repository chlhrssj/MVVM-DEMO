package com.chlhrssj.demo.ui.lifecycle;

import android.util.Log;

/**
 * Create by rssj on 2019-12-02
 */
public class NoLifeObserver {

    private static final String TAG = "NoLifeObserver";

    public void onCreate() {
        Log.d(TAG,"onCreate()");
    }

    public void onStart() {
        Log.d(TAG,"onStart()");
    }

    public void onResume() {
        Log.d(TAG,"onResume()");

    }

    public void onPause() {
        Log.d(TAG,"onPause()");
    }

    public void onStop() {
        Log.d(TAG,"onStop()");
    }

    public void onDestroy() {
        Log.d(TAG,"onDestroy()");
    }

}
