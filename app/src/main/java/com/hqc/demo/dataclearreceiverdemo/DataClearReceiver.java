package com.hqc.demo.dataclearreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.hqc.demo.utils.LogUtils;

public class DataClearReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtils.d("DataClearReceiver","action = "+intent.getAction());
//        LogUtils.d("DataClearReceiver","pkg = "+intent.getStringExtra("packageName"));
    }
}
