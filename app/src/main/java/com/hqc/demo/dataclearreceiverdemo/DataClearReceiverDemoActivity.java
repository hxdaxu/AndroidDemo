package com.hqc.demo.dataclearreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hqc.demo.R;
import com.hqc.demo.utils.LogUtils;

public class DataClearReceiverDemoActivity extends Activity implements View.OnClickListener{

    private static final String GIONEE_CLEAR_ACTION = "com.gionee.clearData";

    private TextView mTextView;
    private Button mButton;
    private DataClearReceiver mDataClearReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_clear_receiver_demo);
        initView();
        registerDataClearReceiver();
    }

    @Override
    protected void onDestroy() {
//        unregisterReceiver(mDataClearReceiver);
        super.onDestroy();
    }

    private void registerDataClearReceiver() {
        mDataClearReceiver = new DataClearReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(GIONEE_CLEAR_ACTION);
//        registerReceiver(mDataClearReceiver,filter);
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.data_clear_reset_textview);
        mButton = (Button) findViewById(R.id.data_clear_reset_button);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.data_clear_reset_button:
                //将textView文字置为初始值
                mTextView.setText("未收到清除数据的广播");
                break;
            default:
                break;

        }
    }

    class DataClearReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            LogUtils.d("DataClearReceiver action = ",action);
            mTextView.setText("received action = "+action);
        }
    }
}
