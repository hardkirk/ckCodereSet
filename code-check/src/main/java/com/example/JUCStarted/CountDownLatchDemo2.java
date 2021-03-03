package com.example.JUCStarted;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 闭锁2 只有当其他线程都完成后才进行执行
 * @author: Chuk
 * @time: 2021/2/23 13:54
 * @Params CountDownLatchDemo2
 */
public class CountDownLatchDemo2 {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);//线程数
        LatchDemo id = new LatchDemo(latch);
        long start =System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(id).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {

        }
        long end =System.currentTimeMillis();
        System.out.println("耗费时间为："+(end -start)+"秒");
    }

}

class LatchDemo implements Runnable {
        private CountDownLatch latch;
        public LatchDemo(CountDownLatch latch) {
            this.latch = latch;
        }
        @Override
        public void run() {
            synchronized (this) {
                try {
                    for (int i = 0; i < 50000; i++) {
                        if (i % 2 == 0) {//50000以内的偶数
                            System.out.println(i);
                        }
                    }
                } finally {
                    latch.countDown();//每执行完一个就递减一个
                }
            }
        }
}

