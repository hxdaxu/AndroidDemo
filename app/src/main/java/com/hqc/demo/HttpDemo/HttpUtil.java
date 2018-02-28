package com.hqc.demo.HttpDemo;

import com.hqc.demo.utils.LogUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by huangqingchun on 18-2-27.
 */

public class HttpUtil {


    static OkHttpClient client = new OkHttpClient();

    public static String doGet(String url) throws Exception{

        final Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtils.i("HttpUtil","doGet on failure.");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtils.i("HttpUtil","doGet success.");
//                response.body().
            }
        });

        return "";
    }


}
