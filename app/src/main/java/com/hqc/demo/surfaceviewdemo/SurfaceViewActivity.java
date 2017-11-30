package com.hqc.demo.surfaceviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hqc.demo.R;
import com.hqc.demo.utils.WifiSsidUtils;

public class SurfaceViewActivity extends Activity implements View.OnClickListener {

    private int[] imageResourceIDs = {
            R.drawable.chronometer_ani_01, R.drawable.chronometer_ani_02,R.drawable.chronometer_ani_03,
            R.drawable.chronometer_ani_04, R.drawable.chronometer_ani_05,
            R.drawable.chronometer_ani_06, R.drawable.chronometer_ani_07, R.drawable.chronometer_ani_08,
            R.drawable.chronometer_ani_09, R.drawable.chronometer_ani_10, R.drawable.chronometer_ani_11,
            R.drawable.chronometer_ani_12, R.drawable.chronometer_ani_13, R.drawable.chronometer_ani_14,
            R.drawable.chronometer_ani_15, R.drawable.chronometer_ani_16, R.drawable.chronometer_ani_17,
            R.drawable.chronometer_ani_18, R.drawable.chronometer_ani_19, R.drawable.chronometer_ani_20,
            R.drawable.chronometer_ani_21, R.drawable.chronometer_ani_22, R.drawable.chronometer_ani_23,
            R.drawable.chronometer_ani_24, R.drawable.chronometer_ani_25, R.drawable.chronometer_ani_26,
            R.drawable.chronometer_ani_27, R.drawable.chronometer_ani_28, R.drawable.chronometer_ani_29,
            R.drawable.chronometer_ani_30, R.drawable.chronometer_ani_31
    };

    private CustomSurfaceView mCustomSurfaceView;
    private Button bt_start;
    private Button bt_pause;
    private Button bt_continue;
    private Button bt_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view_demo);

        initView();

        mCustomSurfaceView = (CustomSurfaceView) findViewById(R.id.surface_view_demo);
        mCustomSurfaceView.setBitmapResoursID(imageResourceIDs);


    }

    private void initView() {
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_pause = (Button) findViewById(R.id.bt_pause);
        bt_continue = (Button) findViewById(R.id.bt_continue);
        bt_reset = (Button) findViewById(R.id.bt_reset);

        bt_start.setOnClickListener(this);
        bt_pause.setOnClickListener(this);
        bt_continue.setOnClickListener(this);
        bt_reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                mCustomSurfaceView.start();
                break;
            case R.id.bt_pause:
                mCustomSurfaceView.pause();
                break;
            case R.id.bt_continue:
                mCustomSurfaceView.continuePlay();
                break;
            case R.id.bt_reset:
                mCustomSurfaceView.reSet();
//                String s = WifiSsidUtils.convertSsid("333630e5858de8b4b9576946692d6878");
//                Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
