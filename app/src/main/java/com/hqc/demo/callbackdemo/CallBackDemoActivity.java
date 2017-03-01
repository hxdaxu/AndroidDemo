package com.hqc.demo.callbackdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hqc.demo.R;

public class CallBackDemoActivity extends Activity implements View.OnClickListener{

    private CallBackTest callBackTest;
    private Button callBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back_demo);
        registerCallBack();
        initView();
    }

    private void initView() {
        callBackBtn = (Button) findViewById(R.id.btn_callback_activity);
        callBackBtn.setOnClickListener(this);
    }

    /**
     * 注册回调，当事件发生时候会调用onEventOccur方法。
     * 这里是被调用者。
     */
    private void registerCallBack() {
        callBackTest = new CallBackTest(new CallBackTest.EventListener() {
            @Override
            public void onEventOccur(String Event) {
                //事件发生时候就弹个toast
                Toast.makeText(CallBackDemoActivity.this,"event occur !! Event:"+Event,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //模拟事件
            case R.id.btn_callback_activity:
                callBackTest.pushAnEvent();
                break;
            default:
                break;
        }
    }
}
