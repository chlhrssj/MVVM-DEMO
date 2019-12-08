package com.chlhrssj.demo.base;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

/**
 * Create by rssj on 2019-12-07
 */
public abstract class BaseObserver<T> extends ResourceObserver<T> {


    /**
     *  执行开始（可选）
     *  它会在subscribe(订阅)刚开始，而事件还未发送之前被调用，可以用于做一些准备工作
     *  它总是在subscribe(订阅)所发生的线程被调用(不合适在主线程加载进度条)
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * 执行结果
     */
    @Override
    public void onComplete() {

    }

    /**
     * 执行错误
     * @param e
     */
    @Override
    public void onError(Throwable e) {

    }
}
