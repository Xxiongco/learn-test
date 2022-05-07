package com.panda.learn_spring_boot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
//实现ApplicationListener接口，并指定监听的事件类型
@Component
public class OneListener implements ApplicationListener<OneEvent> {

    //使用onApplicationEvent方法对消息进行接收处理
    @Override
    public void onApplicationEvent(OneEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("oneone:"+msg);
    }

}