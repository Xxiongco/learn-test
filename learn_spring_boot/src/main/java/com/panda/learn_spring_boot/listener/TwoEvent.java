package com.panda.learn_spring_boot.listener;

import org.springframework.context.ApplicationEvent;

public class TwoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    private String msg;

    public TwoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}