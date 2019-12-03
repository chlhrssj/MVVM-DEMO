package com.chlhrssj.demo.ui.livedata;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.chlhrssj.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SimpleLiveDataActivity extends AppCompatActivity {

    public static final String TAG = "SimpleLiveDataActivity";

    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.tv_num)
    TextView tvNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_live_data);
        ButterKnife.bind(this);

        SimulateNet.getInstance().getIntegerMutableLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.i(TAG, "" + integer);
                tvNum.setText("" + integer);
            }
        });
    }

    @OnClick(R.id.btn_add)
    public void onViewClicked() {
        SimulateNet.getInstance().setCallBack(null);
        SimulateNet.getInstance().start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "destroy");
    }
}
