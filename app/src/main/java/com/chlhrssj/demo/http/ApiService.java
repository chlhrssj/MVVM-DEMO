package com.chlhrssj.demo.http;

import com.chlhrssj.demo.bean.HomeListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    /**
     * 首页列表
     */
    @GET("article/listproject/{page}/json")
    Observable<HomeListBean> getHomeList(@Path("page") String page);

}
