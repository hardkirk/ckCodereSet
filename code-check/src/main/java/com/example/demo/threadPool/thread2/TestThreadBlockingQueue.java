package com.example.demo.threadPool.thread2;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/1 19:26
 * @Params TestThreadBlockingQueue
 */
public class TestThreadBlockingQueue {
    private static int num = 0;


    public static void main(String[] args) {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "在运行" + System.currentTimeMillis());
                Thread.sleep(1000);
                num = setNum(num);
                System.out.println("当前线程序号"+num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(6), Executors.defaultThreadFactory(),
            new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());
//    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 9, 0L, TimeUnit.SECONDS,
//            new LinkedBlockingDeque<>(3));
        for (int i = 0; i < 100; i++) {
        threadPoolExecutor.submit(runnable);
    }
        try {
        Thread.sleep(500);
        System.out.println("A===" + threadPoolExecutor.getCorePoolSize());
        System.out.println("A===" + threadPoolExecutor.getPoolSize());
        System.out.println("A===" + threadPoolExecutor.getQueue().size());
        Thread.sleep(3000);
        System.out.println("B===" + threadPoolExecutor.getCorePoolSize());
        System.out.println("B===" + threadPoolExecutor.getPoolSize());
        System.out.println("B===" + threadPoolExecutor.getQueue().size());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
    public static synchronized int setNum(int num){
        num = num+1;
        return num;
    }
}

