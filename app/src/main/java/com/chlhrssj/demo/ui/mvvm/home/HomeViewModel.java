package com.chlhrssj.demo.ui.mvvm.home;

import androidx.lifecycle.Observer;

import com.chlhrssj.demo.base.BaseEvent;
import com.chlhrssj.demo.base.BaseViewModel;

/**
 * Create by rssj on 2019-12-05
 */
public class HomeViewModel extends BaseViewModel {

    HomeModel homeModel;

    int page = 0;

    public HomeViewModel() {
        super();
        homeModel = new HomeModel();
        getLoadState().addSource(homeModel.getLoadState(), new Observer<BaseEvent>() {
            @Override
            public void onChanged(BaseEvent s) {
                getLoadState().postValue(s);
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        homeModel.unDisposable();
    }

    public void getList(boolean isRefresh) {
        if (isRefresh) {
            page = 0;
        } else {
            page++;
        }
        homeModel.getList(page);
    }
}
