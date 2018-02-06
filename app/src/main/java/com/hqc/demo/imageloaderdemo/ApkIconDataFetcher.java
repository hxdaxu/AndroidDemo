package com.hqc.demo.imageloaderdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.hqc.demo.MyApp;
import com.hqc.demo.R;
import com.hqc.demo.utils.LogUtils;

/**
 * Created by huangqingchun on 18-2-4.
 */

public class ApkIconDataFetcher implements DataFetcher<Drawable> {

    private final String model;

    ApkIconDataFetcher(String model){
        this.model = model;
    }


    @Override
    public void loadData(@NonNull Priority priority, @NonNull DataCallback<? super Drawable> callback) {

        LogUtils.i("apkIconDataFetcher","real load data get apk icon. path = " +model);

        Drawable d = MyApp.getAppContext().getResources().getDrawable(R.drawable.chronometer_ani_01,null);
        callback.onDataReady(d);
    }

    @Override
    public void cleanup() {

    }

    @Override
    public void cancel() {

    }

    @NonNull
    @Override
    public Class<Drawable> getDataClass() {
        return Drawable.class;
    }

    @NonNull
    @Override
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
