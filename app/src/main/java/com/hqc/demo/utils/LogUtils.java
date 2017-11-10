package com.hqc.demo.utils;

public class LogUtils {
    
    private static final boolean isDebug = true;
    private static final String TAG = "AndroidDemo";
    
    public static void d(String tag,String msg){
        if (isDebug) {
            android.util.Log.d(TAG, tag+" - "+msg);
        }
    }

    public static void w(String tag,String msg){
        if (isDebug) {
            android.util.Log.w(TAG, tag+" - "+msg);
        }
    }

    public static void e(String tag,String msg){
        if (isDebug) {
            android.util.Log.e(TAG, tag+" - "+msg);
        }
    }
    public static void i(String tag,String msg){
        if (isDebug) {
            android.util.Log.i(TAG, tag+" - "+msg);
        }
    }
    public static void i(String msg){
        if (isDebug) {
            android.util.Log.i(TAG,msg);
        }
    }
}
