package com.example.demo.threadPool;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/4 17:29
 * @Params CountDownLatchDemo
 */
public class CountDownLatchDemo {
    private static final int N = 2;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(N);
        for (int i = 0; i < N; ++i) // create and start threads
        {
            new Thread(new Worker(doneSignal,i)).start();
        }
        doneSignal.await();
        doSomethingElse(); // don't let run yet
    }
    private static void doSomethingElse() {
        System.out.println("分享牛 我在做其他事情.....");
    }
    static class Worker implements Runnable {
        private CountDownLatch doneSignal;
        private int i;
        public Worker( CountDownLatch doneSignal,int i) {
            this.doneSignal = doneSignal;
            this.i=i;
        }
        public void run() {
            try {
                doWork();
            } catch (Exception e) {

            } finally {
                doneSignal.countDown();
            }
        }
        private void doWork() {
            System.out.println("开始工作....."+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

