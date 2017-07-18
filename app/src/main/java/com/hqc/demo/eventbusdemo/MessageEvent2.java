package com.hqc.demo.eventbusdemo;
/**
 * 此类定义为事件2
 */
public class MessageEvent2 {
    private String message;
    
    public MessageEvent2(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "message : "+message;
    }
}
