package com.hqc.demo.remoteservicedemo;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.hqc.demo.utils.LogUtils;

public class remoteservice extends Service {

    private static final String TAG = "remoteservicedemo";
    private static final int id = 100;



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.d(TAG,"onCreate");
        startForeground(id,new Notification());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.d(TAG,"onStartCommand");



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        LogUtils.d(TAG,"onDestroy");
        stopForeground(true);

        super.onDestroy();
    }
}
