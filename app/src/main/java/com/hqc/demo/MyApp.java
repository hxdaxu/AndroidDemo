package com.hqc.demo;

import android.app.Application;
import android.content.Context;

/**
 * Created by huangqingchun on 18-2-4.
 */

public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext(){
        return context;
    }
}
