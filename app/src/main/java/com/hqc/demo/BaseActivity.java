package com.hqc.demo;

import android.app.Activity;
import android.os.Bundle;

import com.hqc.demo.utils.LogUtils;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
    }

    protected void initView(){

    }

    @Override
    protected void onResume() {
        LogUtils.i("this Activity is " + this.getClass().getSimpleName());
        super.onResume();
    }

    protected abstract int getContentView();
}
