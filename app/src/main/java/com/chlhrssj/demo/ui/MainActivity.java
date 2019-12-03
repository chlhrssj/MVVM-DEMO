package com.chlhrssj.demo.ui;

import android.os.Bundle;
import android.view.View;

import com.chlhrssj.demo.R;
import com.chlhrssj.demo.base.BaseVMActivity;
import com.chlhrssj.demo.ui.lifecycle.LifecycleActivity;
import com.chlhrssj.demo.ui.livedata.NoLiveDataActivity;
import com.chlhrssj.demo.ui.livedata.SimpleLiveDataActivity;
import com.chlhrssj.demo.ui.viewmodel.NoVMActivity;
import com.chlhrssj.demo.ui.viewmodel.SimpleVMActivity;
import com.chlhrssj.demo.ui.viewmodel.SimpleViewModel;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseVMActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.btn_no_vm, R.id.btn_vm, R.id.btn_no_ld, R.id.btn_ld, R.id.btn_vm_ld,
            R.id.btn_lifecycle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_no_vm:
                startAct(NoVMActivity.class);
                break;
            case R.id.btn_vm:
                startAct(SimpleVMActivity.class);
                break;
            case R.id.btn_no_ld:
                startAct(NoLiveDataActivity.class);
                break;
            case R.id.btn_ld:
                startAct(SimpleLiveDataActivity.class);
                break;
            case R.id.btn_vm_ld:
                break;
            case R.id.btn_lifecycle:
                startAct(LifecycleActivity.class);
                break;
        }
    }

}
