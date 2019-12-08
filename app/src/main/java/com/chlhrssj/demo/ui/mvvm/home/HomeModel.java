package com.chlhrssj.demo.ui.mvvm.home;

import androidx.annotation.Nullable;

import com.chlhrssj.demo.base.BaseEvent;
import com.chlhrssj.demo.base.BaseModel;
import com.chlhrssj.demo.base.BaseObserver;
import com.chlhrssj.demo.base.BaseViewModel;
import com.chlhrssj.demo.bean.HomeListBean;
import com.chlhrssj.demo.http.ApiService;
import com.chlhrssj.demo.http.BaseHost;
import com.chlhrssj.demo.http.HttpHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Create by rssj on 2019-12-06
 */
public class HomeModel extends BaseModel {

    public void getList(int page, @Nullable OnCallBack onCallBack) {
        getLoadState().postValue(new BaseEvent(BaseViewModel.LOADING));
        addDisposable(HttpHelper.getDefault(BaseHost.DEFAULTURL)
                .create(ApiService.class)
                .getHomeList("" + page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseObserver<HomeListBean>() {
                                   @Override
                                   public void onNext(HomeListBean homeList) {
                                       if (onCallBack != null) {
                                           if (homeList.getErrorCode() != 0) {
                                               onCallBack.onError(homeList.getErrorMsg());
//                                               loadState.setValue(new BaseEvent());
                                               getLoadState().postValue(new BaseEvent(BaseViewModel.ERROR));
                                           } else if (homeList.getData().getDatas() != null) {
                                               onCallBack.onSuccess(homeList);
                                               getLoadState().postValue(new BaseEvent(BaseViewModel.NORMAL));
                                           } else {
                                               getLoadState().postValue(new BaseEvent(BaseViewModel.NORMAL));
                                           }
                                       }
                                   }

                                   @Override
                                   public void onError(Throwable e) {
                                       super.onError(e);
                                       if (onCallBack != null) {
                                           onCallBack.onError(e.toString());
                                       }
                                   }

                                   @Override
                                   public void onComplete() {
                                       super.onComplete();
                                   }
                               }
                ));
    }

    public interface OnCallBack {
        void onSuccess(HomeListBean homeListBean);
        void onError(String msg);
    }

}
