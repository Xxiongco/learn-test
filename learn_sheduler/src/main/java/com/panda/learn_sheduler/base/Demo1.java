package com.panda.learn_sheduler.base;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 用于学习java定时任务。
 */
public class Demo1 {
    public static void main(String[] args) {
        //demo1();
        demo2();

        System.out.println("end in main");
    }
    public static void demo1(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        },10000);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("world");
        timer.cancel();
    }

    public static void demo2(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(new Date() + " : 任务「ScheduleAtFixedRateDemo」被执行。");
                    }
                },
                0,
                1000,
                TimeUnit.MILLISECONDS);
    }
}