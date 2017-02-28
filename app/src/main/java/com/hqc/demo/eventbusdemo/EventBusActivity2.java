package com.hqc.demo.eventbusdemo;

import org.greenrobot.eventbus.EventBus;

import com.hqc.demo.R;
import com.hqc.demo.utils.Log;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

public class EventBusActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("EventBusActivity2", "onCreate");
        setContentView(R.layout.activity_eventbusactivity2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    
    public void onBtn1Click (View view){
        Log.d("onBtn1Click", "EventBus post message!");
        EventBus.getDefault().post(new MessageEvent1("my name is event1"));
    }
    
    
    public void onBtn2Click (View view){
        Log.d("onBtn2Click", "EventBus post message! in subthread");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("Thread", "thread run begin!");
                EventBus.getDefault().post(new MessageEvent1("my name is event1"));
            }
        }).start();
    }
}
