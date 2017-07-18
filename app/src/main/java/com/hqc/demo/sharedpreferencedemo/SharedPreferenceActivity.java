package com.hqc.demo.sharedpreferencedemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hqc.demo.R;
import com.hqc.demo.utils.Log;

import java.util.HashSet;
import java.util.Set;

public class SharedPreferenceActivity extends Activity {

    private SharedPreferences sp;
    private Set<String> mNumbers;

    private Button addBtn ;
    private int count = 5;

    static final String SET_KEY = "numberSet";
    static final String PREFERENCE_NAME = "test";
    static final String TAG = "SharedPreferenceActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG,"onCreate");

        setContentView(R.layout.activity_shared_preference);

        Set<String> numbers = new HashSet<>();
        Log.d(TAG,"numbers--1 "+numbers.hashCode());
        for (int i = 0;i < 4;i++){
            numbers.add(Integer.toString(i));
        }


        sp = getSharedPreferences(PREFERENCE_NAME,0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet(SET_KEY,numbers);
        editor.commit();

        mNumbers = sp.getStringSet(SET_KEY,new HashSet<String>());

        addBtn = (Button) findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick");
                SharedPreferences spf = getSharedPreferences(PREFERENCE_NAME,0);
                Set<String> numbers = spf.getStringSet(SET_KEY,new HashSet<String>());
                Log.d(TAG,"numbers--2 "+numbers.hashCode());
//                numbers.add(Integer.toString(count));

//                SharedPreferences.Editor editor = spf.edit();
//                editor.putStringSet(SET_KEY,numbers);
//                editor.commit();
//                count++;
                new Thread(new TaskAdd()).start();
                new Thread(new TaskShow()).start();
            }
        });


    }

    class TaskShow implements Runnable {

        @Override
        public void run() {
            Log.d(TAG,"running---start");
            SharedPreferences spf = getSharedPreferences(PREFERENCE_NAME,0);
            Set<String> numbers = spf.getStringSet(SET_KEY,new HashSet<String>());
            Log.d(TAG,"numbers--3 "+mNumbers.hashCode());

            for (String s : mNumbers){
                Log.d(TAG,s);
            }
        }
    }

    class TaskAdd implements Runnable {

        @Override
        public void run() {
            Log.d(TAG,"add running---start");
            SharedPreferences spf = getSharedPreferences(PREFERENCE_NAME,0);
            Set<String> numbers = spf.getStringSet(SET_KEY,new HashSet<String>());
            Log.d(TAG,"numbers--4 "+numbers.hashCode());

            while (true){
                numbers.add(Integer.toString(count));
                Log.d(TAG,"added "+count);
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
