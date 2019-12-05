package com.chlhrssj.demo.ui.mvvm.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chlhrssj.demo.R;
import com.chlhrssj.demo.base.BaseVMActivity;
import com.chlhrssj.demo.base.BaseViewModel;

public class HomeActivity extends BaseVMActivity<HomeViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {

    }

}
