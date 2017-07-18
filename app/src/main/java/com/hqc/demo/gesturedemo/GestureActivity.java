package com.hqc.demo.gesturedemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.hqc.demo.R;

public class GestureActivity extends Activity {

    private static final String TAG = "GestureActivity";
    private int mScreenHeight = 0;
    private GestureDetector mGesture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        mScreenHeight = getWindowManager().getDefaultDisplay().getHeight();
        mGesture = new GestureDetector(this,new myGestureLitener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mGesture != null){
            mGesture.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }


    private class myGestureLitener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent start, MotionEvent end, float velocityX, float velocityY) {
            float startX = start.getRawX();
            float startY = start.getRawY();
            float endX = end.getRawX();
            float endY = end.getRawY();

            if (mScreenHeight - startY <= 45) {
                Log.i(TAG, "onFling :" + mScreenHeight + "," + startY);
                return false;
            }

            double limitDistance = (mScreenHeight * 0.4);
            float distanceInY = getDistanceInY(startY,endY);
            if (distanceInY < limitDistance){
                Log.i(TAG,"onFling: distanceInY < limitDistance distanceInY = "+distanceInY);
                Toast.makeText(GestureActivity.this,"onFling: distanceInY < limitDistance distanceInY = "+distanceInY,Toast.LENGTH_SHORT).show();
                return false;
            }

            boolean isTouchY = isYLargeX(startX, startY, endX, endY);
            if (isTouchY) {
                boolean isUp = isUpFling(startY, endY);
                Log.i(TAG, "onFling-->isUp:" + isUp);
                if (isUp) {
                    Toast.makeText(GestureActivity.this,"onFling-->isUp succeed",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GestureActivity.this,"onFling-->isDown succeed",Toast.LENGTH_SHORT).show();
                }
            } else {
                return false;
            }
            return super.onFling(start, end, velocityX, velocityY);
        }
    }

    public boolean isUpFling(float startY, float endY) {
        return endY < startY;
    }

    public boolean isYLargeX(float startX, float startY, float endX, float endY) {
        float xDistance = Math.abs(endX - startX);
        float yDistance = Math.abs(endY - startY);
        return yDistance > xDistance;
    }

    private float getDistanceInY(float startY,float endY){
        return Math.abs(startY - endY);
    }
}
