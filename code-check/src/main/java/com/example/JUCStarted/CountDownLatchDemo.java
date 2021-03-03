package com.example.JUCStarted;

import java.util.concurrent.CountDownLatch;

/**
 * @description:闭锁 只有当其他线程都完成后才进行执行
 * @author: Chuk
 * @time: 2021/2/23 11:49
 * @Params CountDownLatchDemo
 */
public class CountDownLatchDemo{
    public static void main(String[] args) {
        LatchDemo id = new LatchDemo();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(id).start();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为"+(end -start)+"秒");
    }

    static class LatchDemo implements Runnable{
        private CountDownLatch latch;
        public LatchDemo(){

        }
        @Override
        public void run() {
            for (int i=0;i<5000;i++){
                if (i %2 ==0){
                    System.out.println(i);
                }
            }
        }
    }
}
