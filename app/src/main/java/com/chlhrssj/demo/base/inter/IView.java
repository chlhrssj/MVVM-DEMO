package com.chlhrssj.demo.base.inter;

import android.content.Context;

/**
 * Create by rssj on 2019-11-29
 */
public interface IView {

    /**
     * 网络请求错误,弹框提示
     * @param msg
     * @param code
     */
    void showError(String msg, String code);

    //----------------------------下面用来显示空界面---------------------------//
    /**
     * showNormal 页面
     */
    void showNormal();

    /**
     * Show loading 页面
     */
    void showLoading();
    /**
     * Show EmptyView 页面
     */
    void showEmptyView();
    /**
     * Show error 页面
     */
    void showError();

}
