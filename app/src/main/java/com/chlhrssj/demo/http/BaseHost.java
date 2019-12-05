package com.chlhrssj.demo.http;


/**
 * @Created by TOME .
 * @时间 2018/5/15 17:35
 * @描述 ${TODO}
 */

public class BaseHost {


    public static final String BaseUrl = "https://www.wanandroid.com";

    public static final int DEFAULTURL = 0;

    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host = "";
        switch (hostType) {
            case DEFAULTURL:
                return BaseUrl;
        }
        return host;
    }
}
