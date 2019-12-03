package com.chlhrssj.demo.ui.livedata;

import android.os.CountDownTimer;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

/**
 * Create by rssj on 2019-12-03
 */
public class SimulateNet {

    public static final String TAG = "SimulateNet";

    private static SimulateNet simulateNet;

    private MutableLiveData<Integer> integerMutableLiveData;

    private int integertNum;

    private CountDownTimer timer;

    private CallBack callBack;

    private SimulateNet() {
        integertNum = 100;
        integerMutableLiveData = new MutableLiveData<>();
        integerMutableLiveData.postValue(100);

        timer = new CountDownTimer(100000, 1000) {
            @Override
            public void onTick(long l) {
                int num = (int)l/1000;
                Log.i(TAG, "" + num);
                integerMutableLiveData.postValue(num);
                if (callBack != null) {
                    integertNum = num;
                    callBack.onNumChange(integertNum);
                }
            }

            @Override
            public void onFinish() {

            }
        };
    }

    public static SimulateNet getInstance() {
        if (simulateNet == null) {
            synchronized (SimulateNet.class) {
                if (simulateNet == null) {
                    simulateNet = new SimulateNet();
                }
            }
        }
        return simulateNet;
    }


    public void start() {
        timer.start();
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public MutableLiveData<Integer> getIntegerMutableLiveData() {
        return integerMutableLiveData;
    }

    public interface CallBack {
        void onNumChange(int num);
    }

}
