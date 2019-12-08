package com.chlhrssj.demo.ui.mvvm.home;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.chlhrssj.demo.R;
import com.chlhrssj.demo.base.BaseVMActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseVMActivity<HomeViewModel> {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {

        mViewModel.getList(true);

    }

}
