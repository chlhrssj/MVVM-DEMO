package com.chlhrssj.demo.ui.mvvm.home;

import com.chlhrssj.demo.base.BaseModel;
import com.chlhrssj.demo.base.BaseObserver;
import com.chlhrssj.demo.bean.HomeList;
import com.chlhrssj.demo.http.ApiService;
import com.chlhrssj.demo.http.BaseHost;
import com.chlhrssj.demo.http.HttpHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Create by rssj on 2019-12-06
 */
public class HomeModel extends BaseModel {

    public void getList(int page) {
        addDisposable(HttpHelper.getDefault(BaseHost.DEFAULTURL)
                .create(ApiService.class)
                .getHomeList("" + page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseObserver<HomeList>() {
                                   @Override
                                   public void onNext(HomeList homeList) {
                                       HomeList list = homeList;
                                   }

                                   @Override
                                   public void onError(Throwable e) {
                                       super.onError(e);
                                   }
                               }
                ));
    }

}
