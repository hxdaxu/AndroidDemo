package com.hqc.demo;

import com.hqc.demo.callbackdemo.CallBackDemoActivity;
import com.hqc.demo.dataclearreceiverdemo.DataClearReceiverDemoActivity;
import com.hqc.demo.eventbusdemo.EventBusActivity1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {

    private ListView mListView;

    private String[] mStringArray = { "eventbusDemo", "callbackDemo","DataClearReceiverDemo" };
    private final int DEMO_EVENTBUS = 0;
    private final int DEMO_CALLBACK = 1;
    private final int DEMO_DATA_CLEAR_RECEIVER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.main_listview);
        mListView.setAdapter(new MainListViewAdapter(this, mStringArray));
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        switch (position) {
            case DEMO_EVENTBUS:
                Intent intent0 = new Intent(this, EventBusActivity1.class);
                startActivity(intent0);
                break;
            case DEMO_CALLBACK:
                Intent intent1 = new Intent(this, CallBackDemoActivity.class);
                startActivity(intent1);
                break;
            case DEMO_DATA_CLEAR_RECEIVER:
                Intent intent2 = new Intent(this, DataClearReceiverDemoActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }

    }
}
