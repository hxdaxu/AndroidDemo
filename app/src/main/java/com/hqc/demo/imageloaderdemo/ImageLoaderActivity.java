package com.hqc.demo.imageloaderdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hqc.demo.BaseActivity;
import com.hqc.demo.R;
import com.hqc.demo.utils.LogUtils;

import java.net.URI;
import java.net.URL;

public class ImageLoaderActivity extends BaseActivity implements View.OnClickListener{

    private static final java.lang.String TAG ="ImageLoaderActivity" ;
    private EditText et;
    private Button bt;
    private ImageView iv;

    private String path = "";

    @Override
    protected int getContentView() {
        return R.layout.activity_image_loader;
    }

    @Override
    protected void initView() {
        et = (EditText) findViewById(R.id.path_et);
        bt = (Button) findViewById(R.id.show_bt);
        iv = (ImageView) findViewById(R.id.icon_iv);

        bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.show_bt){
            path = et.getText().toString().trim();
            LogUtils.i(TAG,"path = "+path);

            String url = "https://s1.ax2x.com/2018/02/05/hwFF2.png";
            Glide.with(this)
                    .load(path)
                    .into(iv);
        }
    }
}
