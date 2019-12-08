package com.chlhrssj.demo.ui.mvvm.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.chlhrssj.demo.base.BaseEvent;
import com.chlhrssj.demo.base.BaseViewModel;
import com.chlhrssj.demo.bean.HomeListBean;

import java.util.List;

/**
 * Create by rssj on 2019-12-05
 */
public class HomeViewModel extends BaseViewModel {

    HomeModel homeModel;

    MutableLiveData<HomeListBean.DataBean> datalist;

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

        datalist = new MutableLiveData<>();
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
        homeModel.getList(page, new HomeModel.OnCallBack() {
            @Override
            public void onSuccess(HomeListBean homeListBean) {
                datalist.postValue(homeListBean.getData());
            }

            @Override
            public void onError(String msg) {
                getEventLiveData().postValue(new BaseEvent(0, msg));
            }
        });
    }

    public MutableLiveData<HomeListBean.DataBean> getDatalist() {
        return datalist;
    }
}
