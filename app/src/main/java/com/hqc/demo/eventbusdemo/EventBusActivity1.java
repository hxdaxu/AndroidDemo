package com.hqc.demo.eventbusdemo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import com.hqc.demo.R;
import com.hqc.demo.utils.Log;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EventBusActivity1 extends Activity {
    
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("EventBusActivity1", "onCreate");
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_eventbusactivity1);
        initVeiw();
    }

    private void initVeiw() {
        tv1 = (TextView) findViewById(R.id.tv1_activity1);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
    
    public void onBtn1Click (View view){
        Intent i = new Intent(this,EventBusActivity2.class);
        startActivity(i);
    }
    
    @Subscribe
    public void onEventMainThread(MessageEvent1 event){
//        Toast.makeText(this, event.toString(), Toast.LENGTH_SHORT).show();
        Log.d("onEventMainThread", "event message:"+event.toString()+" threadID:"+Thread.currentThread().getId());
    }
    @Subscribe
    public void onEvent(MessageEvent1 event){
        Log.d("onEvent", "event message:"+event.toString()+" threadID:"+Thread.currentThread().getId());
    }
    @Subscribe
    public void onEventBackgroundThread(MessageEvent1 event){
        Log.d("onEventBackgroundThread", "event message:"+event.toString()+" threadID:"+Thread.currentThread().getId());
    }
    @Subscribe
    public void onEventAsync(MessageEvent1 event){
        Log.d("onEventAsync", "event message:"+event.toString()+" threadID:"+Thread.currentThread().getId());
        tv1.setText(event.toString());
    }
    
/*    onEvent:如果使用onEvent作为订阅函数，那么该事件在哪个线程发布出来的，onEvent就会在这个线程中运行，也就是说发布事件和接收事件线程在同一个线程。使用这个方法时，在onEvent方法中不能执行耗时操作，如果执行耗时操作容易导致事件分发延迟。
    onEventMainThread:如果使用onEventMainThread作为订阅函数，那么不论事件是在哪个线程中发布出来的，onEventMainThread都会在UI线程中执行，接收事件就会在UI线程中运行，这个在Android中是非常有用的，因为在Android中只能在UI线程中跟新UI，所以在onEvnetMainThread方法中是不能执行耗时操作的。
    onEventBackground:如果使用onEventBackgrond作为订阅函数，那么如果事件是在UI线程中发布出来的，那么onEventBackground就会在子线程中运行，如果事件本来就是子线程中发布出来的，那么onEventBackground函数直接在该子线程中执行。
    onEventAsync：使用这个函数作为订阅函数，那么无论事件在哪个线程发布，都会创建新的子线程在执行onEventAsync.*/

}
