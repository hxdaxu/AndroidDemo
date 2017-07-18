package com.hqc.demo.addAlarmDemo;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

import com.hqc.demo.R;
import com.hqc.demo.utils.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddAlarmActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "testNearestAlarm";

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
//                addAlarm();
                break;
            default:
                break;
        }
    }

//    private void addAlarm() {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(Calendar.THURSDAY);
//        list.add(Calendar.WEDNESDAY);
//        list.add(Calendar.MONDAY);
//        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
//        intent.putExtra(AlarmClock.EXTRA_MESSAGE,"alarm name");
//        intent.putExtra(AlarmClock.EXTRA_HOUR,11);
//        intent.putExtra(AlarmClock.EXTRA_MINUTES,30);
//        intent.putIntegerArrayListExtra(AlarmClock.EXTRA_DAYS,list);
//        startActivity(intent);

//        Long now = System.currentTimeMillis();
//        Cursor cursor = null;
//        Uri uri = Uri.parse("content://com.android.deskclock/nearestalarm");
//        UserManager userManager = (UserManager) context.getSystemService(Context.USER_SERVICE);
//        List<UserInfo> users = userManager.getUsers(true);
//        final int count = users.size();
//        Log.i(TAG,"user count = "+count);
//
//        NearestAlarm nearestAlarm = new NearestAlarm();
//        for (int i = 0; i < count; i++) {
//            NearestAlarm tempNearestAlarm = null;
//            final UserInfo user = users.get(i);
//            Log.i(TAG,"user id = "+user.id);
//            try {
//                cursor = context.getContentResolver().query(ContentProvider.maybeAddUserId(uri, user.id)
//                        , null, null,
//                        null, null);
//                Log.i(TAG,"cursor = null :"+(cursor == null));
//                if (cursor != null) {
//                    if (cursor.moveToFirst()) {
//                        tempNearestAlarm = new NearestAlarm(cursor);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (null != cursor) {
//                    cursor.close();
//                }
//            }
//
//            if(tempNearestAlarm != null) {
//                Log.i(TAG,"time = "+tempNearestAlarm.getTime());
//                if (tempNearestAlarm.getTime() < now){
//                    if (Math.abs(now - tempNearestAlarm.getTime()) < Math.abs(now - nearestAlarm.getTime())){
//                        nearestAlarm = tempNearestAlarm;
//                        nearestAlarm.setUserId(user.id);
//                        Log.i("alarms","alarmId = "+nearestAlarm.getId()+",time = "+nearestAlarm.getTime()+",userId = "+nearestAlarm.getUserId());
//                    }
//                }
//            }
//        }
//        Log.i("alarms","alarmId = "+nearestAlarm.getId()+",time = "+nearestAlarm.getTime()+",userId = "+nearestAlarm.getUserId());
//        if (nearestAlarm.getId() == -1) {
//            Log.e("Exception : receive powerOff broadcast but nearest alarm is not ready. ");
//            return null;
//        }
//
//        return nearestAlarm;
//    }
}