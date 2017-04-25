package com.hqc.demo.dataclearreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.hqc.demo.utils.Log;

public class DataClearReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("DataClearReceiver","action = "+intent.getAction());
//        Log.d("DataClearReceiver","pkg = "+intent.getStringExtra("packageName"));
    }
}
