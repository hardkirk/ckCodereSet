package com.example.demo.threadPool.thread;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/8 11:34
 * @Params CountDownLatchDemo2
 */
public class CountDownLatchDemo2 {
    //记录开始时间
    long startTime=System.currentTimeMillis();

    Thread countUserThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });


}
