package com.example.JUCStarted.threads;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/3/3 9:50
 * @Params ThreadsDemo
 */
public class ThreadsDemo {
    private static volatile Integer  count = 0;
    /**
     * 多线程程序并不能提高程序的运行速度，但能够提高程序运行效率，让CPU的使用率更高
     * 线程安全，自旋锁AQS，原子性操作，线程池,原子类AtomicInteger
     */
    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,3,0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
//        for (int i = 0; i < 50; i++) {
//            poolExecutor.submit(new ThreadTest());
//        }
        ThreadTest t1 = new ThreadTest();
        ThreadTest t2 = new ThreadTest();
        t1.run();
        t2.run();
    }

    static class ThreadTest implements Runnable {

//        public ThreadTest(int count){
//            this.count = count++;
//        }
        @Override
        public void run() {
            try {
                count++;
                System.out.println(count);
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }


}
