package com.chlhrssj.demo.http;

import com.chlhrssj.demo.bean.HomeList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    /**
     * 首页列表
     */
    @GET("article/listproject/{page}/json")
    Observable<HomeList> getHomeList(@Path("page") String page);

}
