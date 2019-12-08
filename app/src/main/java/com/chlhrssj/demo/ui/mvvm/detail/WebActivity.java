package com.chlhrssj.demo.ui.mvvm.detail;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.chlhrssj.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends AppCompatActivity {

    String url;
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        url = getIntent().getStringExtra("URL");

        webView.getSettings().setJavaScriptEnabled(true);//开启js交互
        webView.getSettings().setSupportZoom(false); //支持缩放，默认为true。是下面那个的前提。
        webView.getSettings().setBuiltInZoomControls(false); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webView.getSettings().setDisplayZoomControls(false); //隐藏原生的缩放控件
        webView.getSettings().setBlockNetworkImage(false);//解决图片不显示
        webView.getSettings().setLoadsImagesAutomatically(true); //支持自动加载图片
        webView.getSettings().setDefaultTextEncodingName("utf-8");//设置编码格式
        webView.getSettings().setSavePassword(false);//关闭密码保存功能
        webView.getSettings().setAllowFileAccess(false);//关闭File协议
        webView.clearCache(true);
        webView.loadUrl(url);
    }
}
