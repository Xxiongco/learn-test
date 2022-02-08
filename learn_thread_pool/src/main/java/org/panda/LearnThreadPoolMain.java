package org.panda;

import java.util.concurrent.*;

/**
 * 用于学习ThreadPool的源码
 */
public class LearnThreadPoolMain {
    public static void main(String[] args) {
        //nThreads => 最大线程数即maximumPoolSize
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);



        fixedThreadPool.submit(new Runnable() {
                                   @Override
                                   public void run() {
                                       System.out.println("hello");
                                   }
                               });


                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());






    }
}
