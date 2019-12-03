package com.chlhrssj.demo.ui.livedata;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chlhrssj.demo.R;
import com.chlhrssj.demo.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoLiveDataActivity extends AppCompatActivity {

    public static final String TAG = "NoLiveDataActivity";

    @BindView(R.id.btn_add)
    Button btnAdd;

    TextView tvNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_live_data);
        ButterKnife.bind(this);

        tvNum = findViewById(R.id.tv_num);

        SimulateNet.getInstance().setCallBack(new SimulateNet.CallBack() {
            @Override
            public void onNumChange(int num) {
                Log.i(TAG, "" + num);
                if (tvNum != null) {
                    tvNum.setText("" + num);
                }
            }
        });

    }

    @OnClick({R.id.btn_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                SimulateNet.getInstance().start();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "destroy");
    }
}
