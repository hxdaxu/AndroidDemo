package com.hqc.demo.callbackdemo;

public class CallBackTest {
    private EventListener mEventListener;
    
    //构造
    public CallBackTest(EventListener callBack) {
        this.mEventListener = callBack;
    }

    //注册
    public void setEventListener(EventListener callBack){
        this.mEventListener = callBack;
    }
    
    //当事件发生时候
    public void pushAnEvent(){
        String event = "今天放假";
        //这里是发生事件时候，调用者。将参数传入。
        mEventListener.onEventOccur(event);
    }

    /**
     * 定义回调接口
     */
    interface EventListener{
        //定义参数
        void onEventOccur(String Event);
    } 
}

