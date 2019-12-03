package com.chlhrssj.demo.ui.viewmodel;

import androidx.lifecycle.ViewModel;

/**
 * Create by rssj on 2019-12-03
 */
public class SimpleViewModel extends ViewModel {

    private int num = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
