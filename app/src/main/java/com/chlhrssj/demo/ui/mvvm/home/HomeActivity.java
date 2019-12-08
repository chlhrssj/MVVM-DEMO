package com.chlhrssj.demo.ui.mvvm.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chlhrssj.demo.R;
import com.chlhrssj.demo.base.BaseVMActivity;
import com.chlhrssj.demo.bean.HomeListBean;
import com.chlhrssj.demo.ui.mvvm.detail.WebActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseVMActivity<HomeViewModel> {

    private static final String TAG = "HomeActivity";

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;

    HomeAdapter homeAdapter;
    List<HomeListBean.DataBean.DatasBean> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {

        homeAdapter = new HomeAdapter(list);
        homeAdapter.setOnItemClickListener((adapter, view, position) -> {
            HomeListBean.DataBean.DatasBean datasBean = homeAdapter.getData().get(position);
            Intent intent = new Intent(HomeActivity.this, WebActivity.class);
            intent.putExtra("URL", datasBean.getLink());
            startActivity(intent);
        });
        recycler.setAdapter(homeAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        smart.setEnableRefresh(true);//是否启用下拉刷新功能
        smart.setEnableLoadMore(true);//是否启用上拉加载功能
        smart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mViewModel.getList(false);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mViewModel.getList(true);
            }
        });


        mViewModel.getDatalist().observe(this, new Observer<HomeListBean.DataBean>() {
            @Override
            public void onChanged(HomeListBean.DataBean datasBean) {
                if (datasBean.getCurPage() == 1) {
                    list.clear();
                }
                list.addAll(datasBean.getDatas());
                homeAdapter.notifyDataSetChanged();
            }
        });

        smart.autoRefresh();

    }

    @Override
    public void showNormal() {
        super.showNormal();
        smart.finishRefresh();
        smart.finishLoadMore();
        Log.i(TAG, "showNormal");
    }

    @Override
    public void showLoading() {
        super.showLoading();
        Log.i(TAG, "showLoading");
    }

    @Override
    public void showEmptyView() {
        super.showEmptyView();
        Log.i(TAG, "showEmpty");
    }

    @Override
    public void showError() {
        super.showError();
        Log.i(TAG, "showError");
    }
}
