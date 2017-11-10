package com.hqc.demo.remoteservicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hqc.demo.R;
import com.hqc.demo.utils.LogUtils;

public class ServiceControlActivity extends Activity implements View.OnClickListener {

    Button start;
    Button stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_control);
        start = (Button) findViewById(R.id.bt_start);
        start.setOnClickListener(this);
        stop = (Button) findViewById(R.id.bt_stop);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_start:
                LogUtils.i("start service !");
                Intent intent = new Intent(this,remoteservice.class);
                startService(intent);
                break;
            case R.id.bt_stop:
                LogUtils.i("stop service !");
                Intent intent1 = new Intent(this,remoteservice.class);
                stopService(intent1);
                break;
        }
    }
}
