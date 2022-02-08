package org.panda;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class lockLearnMain {
    private static Lock lock = new ReentrantLock(true);

    public static void test() {
        for (int i = 0; i < 20; i++) {
            try {

                System.out.println(Thread.currentThread().getName() + "等待" + " : " + " i = " + i);
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了锁" + " : " + " i = " + i);
                System.out.println("*******************************");
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread("线程A") {
            @Override
            public void run() {
                test();
            }
        }.start();
        new Thread("线程B") {
            @Override
            public void run() {
                test();
            }
        }.start();
    }
}