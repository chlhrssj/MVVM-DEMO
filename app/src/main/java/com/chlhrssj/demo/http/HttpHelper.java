package com.chlhrssj.demo.http;

import android.text.TextUtils;
import android.util.SparseArray;

import androidx.annotation.NonNull;

import com.chlhrssj.demo.BuildConfig;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Created by TOME .
 * @时间 2018/5/15 16:21
 * @描述 ${TODO}
 */

public class HttpHelper {

    /**
     * 多少种Host类型
     */
    public static final int TYPE_COUNT = 5;

    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 30000;
    //连接时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 30000;
    //设缓存有效期为两天
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    //查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
    //max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    //查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
    //(假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
    private static final String CACHE_CONTROL_AGE = "max-age=0";
    private Retrofit retrofit;
    public OkHttpClient okHttpClient;

    //sparsearray 比 hashmap 更优化内存
    private static SparseArray<HttpHelper> sRetrofitManager = new SparseArray<>(TYPE_COUNT);

    /*************************缓存设置*********************/
/*
   1. noCache 不使用缓存，全部走网络

    2. noStore 不使用缓存，也不存储缓存

    3. onlyIfCached 只使用缓存

    4. maxAge 设置最大失效时间，失效则不使用 需要服务器配合

    5. maxStale 设置最大失效时间，失效则不使用 需要服务器配合 感觉这两个类似 还没怎么弄清楚，清楚的同学欢迎留言

    6. minFresh 设置有效时间，依旧如上

    7. FORCE_NETWORK 只走网络

    8. FORCE_CACHE 只走缓存*/

    /**
     * 构造方法私有
     *
     * @param hostType
     */
    private HttpHelper(int hostType) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // okHttpClient = new OkHttpClient.Builder();

        builder.readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                // .addInterceptor(mRewriteCacheControlInterceptor)
                //  .addNetworkInterceptor(mRewriteCacheControlInterceptor)
//                .addNetworkInterceptor(new StethoInterceptor())
        // .addInterceptor(headerInterceptor)
        ;
        // .cache(cache)
        // .build();

        okHttpClient = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BaseHost.getHost(hostType))
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        // movieService = retrofit.create(ApiService.class);
    }

    public static Retrofit getDefault(int hostType) {
        HttpHelper retrofitManager = sRetrofitManager.get(hostType);
        if (retrofitManager == null) {
            retrofitManager = new HttpHelper(hostType);
            sRetrofitManager.put(hostType, retrofitManager);
            return retrofitManager.retrofit;
        }

        return retrofitManager.retrofit;
    }

}
