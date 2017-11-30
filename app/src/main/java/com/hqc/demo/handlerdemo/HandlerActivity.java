package com.hqc.demo.handlerdemo;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.util.HashMap;
import java.util.Map;


public class HandlerActivity extends Activity implements Handler.Callback {

    Handler handler = new Handler(this);
    HashMap<String,String> map = new HashMap<>();



    @Override
    public boolean handleMessage(Message msg) {


        return false;
    }
}
