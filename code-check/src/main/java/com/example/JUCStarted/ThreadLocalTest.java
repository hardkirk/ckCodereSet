package com.example.JUCStarted;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/23 9:46
 * @Params ThreadLocalTest
 */
public class ThreadLocalTest {
        private static final int THREADS_CONUT = 20;
        public static AtomicInteger count = new AtomicInteger(0);
//        public volatile static int count = 0;  volatile只能保证变量在线程之间的可见性，斌不能保证原子性

        public static void increase() {
//            count++;
            count.incrementAndGet();
        }

        public static void main(String[] args) {
            Thread[] threads = new Thread[THREADS_CONUT];
            for (int i = 0; i < THREADS_CONUT; i++) {
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000; i++) {
                            increase();
                        }
                    }
                });
                threads[i].start();
            }

            while (Thread.activeCount() > 1) {
                Thread.yield();
            }
            System.out.println(count);
        }

}
