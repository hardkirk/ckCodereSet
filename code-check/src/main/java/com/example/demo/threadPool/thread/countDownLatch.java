package com.example.demo.threadPool.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/8 9:59
 * @Params countDownLatch
 */
public class countDownLatch {
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new Player(begin,end),String.valueOf(i));
            thread.start();
        }
    }


    static class Player implements Runnable{
        private CountDownLatch begin;
        private CountDownLatch end;
        Player(CountDownLatch begin,CountDownLatch end){
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+ "   start");
            begin.await();
                System.out.println(Thread.currentThread().getName() + " arrived !");
            end.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
