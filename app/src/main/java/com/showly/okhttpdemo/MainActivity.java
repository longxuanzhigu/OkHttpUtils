package com.showly.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.showly.okhttpdemo.bean.MobileCaptcha;
import com.showly.okhttpdemo.http.OkHttpUtils;
import com.showly.okhttpdemo.http.response.GsonResponseHandler;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    public final static String TAG = "MainActivity";
    private static final String baseURL = "http://192.168.1.102:8066";
    public static final String GETVERIFY = baseURL + "/loginapi/shortmsg/getShortMsg.do";


    private Button btnGet;
    private Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    private void initView() {
        btnGet = (Button) findViewById(R.id.btn_get);
        btnPost = (Button) findViewById(R.id.btn_post);
    }

    private void initData() {
        btnGet.setOnClickListener(this);
        btnPost.setOnClickListener(this);
    }

    private void initListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                setGetRequest();//Get请求
                break;
            case R.id.btn_post:
                setPostRequest();//Post请求
                break;
            default:
                break;
        }
    }

    private void setPostRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("phone", "18316021470");

        OkHttpUtils.get().get(MainActivity.this, GETVERIFY, map, new GsonResponseHandler<MobileCaptcha>() {
            @Override
            public void onSuccess(int statusCode, MobileCaptcha response) {
                Log.i("MainActivity=11=", statusCode + "----" + response.getStatus() + "---" + response.getMsg());
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                Log.i("MainActivity=11=", statusCode + "---" + error_msg);
            }
        });


    }

    private void setGetRequest() {
        Map<String, String> params = new HashMap<>();
        params.put("phone", "18316021470");

        OkHttpUtils.get().post(MainActivity.this, GETVERIFY, params, new GsonResponseHandler<MobileCaptcha>() {
            @Override
            public void onSuccess(int statusCode, MobileCaptcha response) {
                Log.i("MainActivity=22=", statusCode + "----" + response.getStatus() + "---" + response.getMsg());
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                Log.i("MainActivity=22=", statusCode + "---" + error_msg);
            }
        });

    }
}
