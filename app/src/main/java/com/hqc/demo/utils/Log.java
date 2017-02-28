package com.hqc.demo.utils;

public class Log {
    
    private static final boolean isDebug = true;
    private static final String TAG = "AndroidDemo";
    
    public static void d(String tag,String msg){
        if (isDebug) {
            android.util.Log.d(TAG, tag+" - "+msg);
        }
    }
}
