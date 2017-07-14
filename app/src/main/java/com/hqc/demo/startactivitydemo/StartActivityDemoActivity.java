package com.hqc.demo.startactivitydemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hqc.demo.R;

public class StartActivityDemoActivity extends Activity {

    public static final String START_ACTIVITY_ACTION = "com.android.demo.START_TEST_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_demo);
    }

    public void sendBroadcastOpenActivity(View v){
        Intent intent = new Intent(START_ACTIVITY_ACTION);
        sendBroadcast(intent);
    }


}
