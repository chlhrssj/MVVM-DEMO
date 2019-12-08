package com.chlhrssj.demo.ui.mvvm.home;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chlhrssj.demo.R;
import com.chlhrssj.demo.bean.HomeListBean;

import java.util.List;

/**
 * Create by rssj on 2019-12-08
 */
public class HomeAdapter extends BaseQuickAdapter<HomeListBean.DataBean.DatasBean, BaseViewHolder> {

    public HomeAdapter(@Nullable List<HomeListBean.DataBean.DatasBean> data) {
        super(R.layout.item_home, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HomeListBean.DataBean.DatasBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_time, item.getNiceDate())
                .setText(R.id.tv_type, item.getChapterName());

        Glide.with(mContext)
                .load(item.getEnvelopePic())
                .into(helper.<ImageView>getView(R.id.iv_cover));
    }
}
