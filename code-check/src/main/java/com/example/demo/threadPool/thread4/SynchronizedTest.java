package com.example.demo.threadPool.thread4;

import com.example.demo.threadPool.thread.RunableDemo;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import javax.annotation.Resource;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:  利用线程池处理
 * @author: Chuk
 * @time: 2021/2/4 14:18
 * @Params SynchronizedTest
 */
public class SynchronizedTest {

    static class MyThread implements Runnable {
        private int y;

        MyThread(String name,int y){
            this.y = y;
        }
        public void run() {
            try {
                int i = changeNum(y);
                Thread.sleep(500);
                System.out.println("当前数值为"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static  int changeNum(int y){
        int b = y+1;
        return b;
    }
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(6), Executors.defaultThreadFactory(),
                new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(new MyThread("线程"+i+"号开始",i));
        }
    }
}
