package com.hqc.demo.imageloaderdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.hqc.demo.utils.LogUtils;

/**
 * Created by huangqingchun on 18-2-5.
 */
@GlideModule
public class MyGlideModel extends AppGlideModule {

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.prepend(String.class, Drawable.class,new ApkIconModelLoader.Factory());
        LogUtils.i("MyGlideModel","registerComponents.");
    }
}
