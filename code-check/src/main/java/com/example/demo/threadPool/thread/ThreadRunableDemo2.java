package com.example.demo.threadPool.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author chuke
 * @create 2020/11/18 20:15
 */
public class ThreadRunableDemo2 implements Runnable{
    private final static java.util.concurrent.ExecutorService ExecutorService =
            new ThreadPoolExecutor(2,3,60, TimeUnit.MINUTES,new LinkedBlockingDeque<Runnable>());
    private int ticketNums = 10;
    @Override
    public void run() {
        for (int i = 0; i < ticketNums; i++) {


        if (ticketNums!=0){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"->拿到了"+ticketNums+"票");
        }

        ticketNums --;
        }
    }

    public static void main(String[] args) {
        ThreadRunableDemo2 demo = new ThreadRunableDemo2();
        Thread thread3 = new Thread(demo,"狗");
        Thread thread1 = new Thread(demo,"猫");
        Thread thread2 = new Thread(demo,"人");
        thread3.start();
        thread2.start();
        thread1.start();
    }
}
