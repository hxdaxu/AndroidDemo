package com.hqc.demo.surfaceviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by hxdaxu on 2017/4/24.
 */

public class CustomSurfaceView extends SurfaceView {






    public CustomSurfaceView(Context context) {
        super(context,null);
    }

    public CustomSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public CustomSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
}
