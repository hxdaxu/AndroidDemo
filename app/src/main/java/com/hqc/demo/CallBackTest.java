package com.hqc.demo;

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
    public void handleEvent(){
        String event = "今天放假";
        mEventListener.onEventOccur(event);
    }
    
    interface EventListener{
        void onEventOccur(String Event);
    } 
}

