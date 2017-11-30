package com.hqc.demo.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hqc.demo.BaseActivity;
import com.hqc.demo.R;

public class RecyclerViewActivity extends BaseActivity {

    private RecyclerView mRecycleView;

    @Override
    protected int getContentView() {
        return R.layout.activity_recycler_view;
    }

    @Override
    protected void initView() {
        mRecycleView = (RecyclerView) findViewById(R.id.recycle_view);


    }
}
