package com.hqc.demo.startactivitydemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.hqc.demo.utils.Log;


public class StartActivityReceiver extends BroadcastReceiver {

    private static final String TAG = "StartActivityReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"action = "+ intent.getAction());
        Intent i = new Intent(context,TestActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
