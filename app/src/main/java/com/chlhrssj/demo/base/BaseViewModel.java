package com.chlhrssj.demo.base;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Create by rssj on 2019-12-05
 */
public class BaseViewModel extends ViewModel {

    public static final int NORMAL = 0;
    public static final int ERROR = 1;
    public static final int LOADING = 2;
    public static final int EMPTY = 3;

    private MediatorLiveData<BaseEvent> loadState = new MediatorLiveData<>();

    public static final int TOASTMSG = 1001;

    private MutableLiveData<BaseEvent<String>> eventLiveData = new MutableLiveData<>();


    public MutableLiveData<BaseEvent<String>> getEventLiveData() {
        return eventLiveData;
    }

    public MediatorLiveData<BaseEvent> getLoadState() {
        return loadState;
    }
}
