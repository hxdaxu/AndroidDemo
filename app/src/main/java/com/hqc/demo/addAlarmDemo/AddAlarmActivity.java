package com.hqc.demo.addAlarmDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

import com.hqc.demo.R;

import java.util.ArrayList;
import java.util.Calendar;

public class AddAlarmActivity extends Activity implements View.OnClickListener{

    private Button addAlarmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        initView();
    }

    private void initView() {
        addAlarmBtn = (Button) findViewById(R.id.btn_add_alarm);
        addAlarmBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_add_alarm:
                addAlarm();
                break;
            default:
                break;
        }
    }

    private void addAlarm() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(Calendar.THURSDAY);
        list.add(Calendar.WEDNESDAY);
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra("android.intent.extra.alarm.HOUR",11);
        intent.putExtra("android.intent.extra.alarm.MINUTES",30);
        intent.putIntegerArrayListExtra("android.intent.extra.alarm.DAYS",list);
        startActivity(intent);
    }
}
