package com.padna.learn_async.springAsync;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TestAsync {
    @Async
    public void test(){

        String name = Thread.currentThread().getName();

        System.out.println(name +  " : in test");
        try {
            Thread.sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " : will out test");
    }
}
