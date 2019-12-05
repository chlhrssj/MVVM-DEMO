package com.chlhrssj.demo.base;


import androidx.annotation.Nullable;

/**
 * Create by rssj on 2019-12-05
 */
public class BaseEvent<T extends Object> {

    public int arg1;
    public int arg2;
    public T obj;
    public int what;

    public BaseEvent(int what) {
        this(what, null);
    }

    public BaseEvent(int what, @Nullable T obj) {
        this(what, obj, 0);
    }

    public BaseEvent(int what, @Nullable T obj, int arg1) {
        this(what, obj, arg1, 0);
    }

    public BaseEvent(int what, @Nullable T obj, int arg1, int arg2) {
        setWhat(what);
        setObj(obj);
        setArg1(arg1);
        setArg2(arg2);
    }

    public int getArg1() {
        return arg1;
    }

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public int getArg2() {
        return arg2;
    }

    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getWhat() {
        return what;
    }

    public void setWhat(int what) {
        this.what = what;
    }
}
