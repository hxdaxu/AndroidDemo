package com.hqc.demo.surfaceviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import com.hqc.demo.utils.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private static final String TAG = "CustomSurfaceView";

    private SurfaceHolder mSurfaceHolder;

    private boolean mIsThreadRunning = true; // 线程运行开关
    private boolean mIsDestroy = false;// 是否已经销毁

    private int[] mBitmapResourceIds;// 用于播放动画的图片资源数组
    private Canvas mCanvas;
    private Bitmap mBitmap;// 显示的图片

    private int mCurrentIndext;// 当前动画播放的位置
    private int mGapTime = 50;// 每帧动画持续存在的时间

    public CustomSurfaceView(Context context) {
        this(context, null);
    }

    public CustomSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomSurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mSurfaceHolder = this.getHolder();
        mSurfaceHolder.addCallback(this);// 注册回调方法

        setZOrderOnTop(true);
        mSurfaceHolder.setFormat(PixelFormat.TRANSLUCENT);//界面透明
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsThreadRunning = false;

        mIsDestroy = true;
    }

    /**
     * 绘图方法
     */
    private void drawView() {
        // 无资源文件退出
        if (mBitmapResourceIds == null) {
            Log.e(TAG, "the bitmapsrcIDs is null");
            mIsThreadRunning = false;
            return;
        }

        // 锁定画布
        mCanvas = mSurfaceHolder.lockCanvas();
        try {
            if (mSurfaceHolder != null && mCanvas != null) {

                mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);// 清除屏幕

                mBitmap = BitmapFactory.decodeResource(getResources(), mBitmapResourceIds[mCurrentIndext]);
                mCanvas.drawBitmap(mBitmap, 0, 0, null);

                // 循环播放
                if (mCurrentIndext >= mBitmapResourceIds.length - 1) {
                    mCurrentIndext = 0;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mCurrentIndext++;

            if (mCanvas != null) {
                // 将画布解锁并显示在屏幕上
                mSurfaceHolder.unlockCanvasAndPost(mCanvas);
            }

            if (mBitmap != null) {
                // 收回图片
                mBitmap.recycle();
            }
        }
    }

    @Override
    public void run() {
        synchronized (mSurfaceHolder){
            while (mIsThreadRunning) {
                drawView();
                try {
                    Thread.sleep(mGapTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 设置动画播放素材
     */
    public void setBitmapResoursID(int[] bitmapResourceIds) {
        this.mBitmapResourceIds = bitmapResourceIds;
    }

    /**
     * 设置每帧时间
     */
    public void setGapTime(int gapTime) {
        this.mGapTime = gapTime;
    }

    /**
     * start the animation.
     */
    public void start() {
        if (!mIsDestroy) {
            mCurrentIndext = 0;
            mIsThreadRunning = true;
            new Thread(this).start();
        } else {
            // 如果SurfaceHolder已经销毁抛出该异常
            try {
                throw new Exception("IllegalArgumentException:Are you sure the SurfaceHolder is not destroyed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * pause
     */
    public void pause() {
        mIsThreadRunning = false;
    }

    /**
     * continue
     */
    public void continuePlay() {
        mIsThreadRunning = true;
        new Thread(this).start();
    }

    /**
     * reset
     */
    public void reSet() {
        mIsThreadRunning = false;
        mCurrentIndext = 0;
        if (mCanvas != null){
            mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        }
    }
}