package com.chlhrssj.demo.ui.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chlhrssj.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SimpleVMActivity extends AppCompatActivity {

    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.tv_num)
    TextView tvNum;

    SimpleViewModel simpleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_vm);
        ButterKnife.bind(this);

        simpleViewModel = new ViewModelProvider(this).get(SimpleViewModel.class);

        tvNum.setText("" + simpleViewModel.getNum());
    }

    @OnClick({R.id.btn_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                simpleViewModel.setNum(simpleViewModel.getNum() + 1);
                tvNum.setText("" + simpleViewModel.getNum());
                break;
        }
    }
}
