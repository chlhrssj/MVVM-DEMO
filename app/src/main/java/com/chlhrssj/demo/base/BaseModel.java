package com.chlhrssj.demo.base;

import androidx.lifecycle.MutableLiveData;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Create by rssj on 2019-12-06
 */
public abstract class BaseModel {

    private CompositeDisposable mCompositeDisposable;

    protected MutableLiveData<BaseEvent> loadState;


    public BaseModel() {
        loadState = new MutableLiveData<>();
    }

    protected void postState(BaseEvent state) {
        if (loadState != null) {
            loadState.postValue(state);
        }

    }

    protected void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    public void unDisposable() {
        if (mCompositeDisposable != null && mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.clear();
        }
    }

    public MutableLiveData<BaseEvent> getLoadState() {
        return loadState;
    }
}
