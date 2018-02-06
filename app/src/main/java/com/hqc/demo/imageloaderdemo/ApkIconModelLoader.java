package com.hqc.demo.imageloaderdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import com.hqc.demo.utils.LogUtils;

import java.io.File;

/**
 * Created by huangqingchun on 18-2-3.
 */

public class ApkIconModelLoader implements ModelLoader<String,Drawable> {
    @Nullable
    @Override
    public LoadData<Drawable> buildLoadData(@NonNull String path, int width, int height, @NonNull Options options) {



        return new LoadData<>(new ObjectKey(path), /*fetcher=*/ new ApkIconDataFetcher(path));
    }

    @Override
    public boolean handles(@NonNull String path) {
        // 如果是apk文件，返回true
        LogUtils.i("ApkIconModelLoader","path = "+path);
        LogUtils.i("ApkIconModelLoader","endsWith .apk ? "+path.endsWith(".apk"));
        return  path.endsWith(".apk");
    }

    public static class Factory implements ModelLoaderFactory<String, Drawable> {

        @NonNull
        @Override
        public ModelLoader<String, Drawable> build(@NonNull MultiModelLoaderFactory multiFactory) {
            return new ApkIconModelLoader();
        }

        @Override
        public void teardown() {

        }
    }
}
