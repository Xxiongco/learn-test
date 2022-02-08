package com.panda.learn_async.base;


import java.util.concurrent.*;

/**
 * 用于学习基础的java异步操作
 * 异步操作有三个方法
 * 1. Future
 * 2. CompletableFuture
 * 3. Spring 的 Async注解
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        //test1();
        test2();
    }

    /**  1.8之后 CompletableFuture */
    public static void test2(){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(Demo::getSomething, executor);
        future.thenAccept(e -> System.out.println(e + " ok"));
        System.out.println("main thread is running");
        executor.shutdown();
    }


    /** 1.8之前的Future */
    public static void test1() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> submit = executor.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("task started!");
                Thread.sleep(10000L);
                System.out.println("task finished!");
                return "hello";
            }
        });

        while (!submit.isDone()){
            System.out.println("*****  wait task finish");
            Thread.sleep(1000L);
        }
        String s = submit.get();
        System.out.println(s);
        executor.shutdown();
    }


    public static String getSomething(){
        System.out.println("task started!");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task finished!");
        return "hello";
    }

}
