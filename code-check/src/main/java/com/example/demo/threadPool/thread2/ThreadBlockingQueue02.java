package com.example.demo.threadPool.thread2;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/7 17:18
 * @Params ThreadBlockingQueue02
 */
public class ThreadBlockingQueue02 {
        private static int num = 0;
    private static CountDownLatch countDownLatch=new CountDownLatch(4);

        public static void main(String[] args) {
            long startTime=System.currentTimeMillis();
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(Thread.currentThread().getName() + "在运行" + System.currentTimeMillis());
//                        Thread.sleep(1000);
//                        num = setNum(num);
//                        System.out.println("当前线程序号"+num);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 2, TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(),
                    new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());
//    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 9, 0L, TimeUnit.SECONDS,
//            new LinkedBlockingDeque<>(3));
//            for (int i = 0; i < 3; i++) {
                threadPoolExecutor.submit(new MyThreadDemo(1));
                threadPoolExecutor.submit(new MyThreadDemo(2));
                threadPoolExecutor.submit(new MyThreadDemo(3));
                threadPoolExecutor.submit(new MyThreadDemo(4));
                threadPoolExecutor.submit(new MyThreadDemo(5));
                threadPoolExecutor.submit(new MyThreadDemo(6));
                threadPoolExecutor.submit(new MyThreadDemo(7));
                threadPoolExecutor.submit(new MyThreadDemo(8));
                threadPoolExecutor.submit(new MyThreadDemo(9));
                threadPoolExecutor.submit(new MyThreadDemo(10));
                threadPoolExecutor.submit(new MyThreadDemo(11));
                threadPoolExecutor.submit(new MyThreadDemo(12));
//            }
            try {
                countDownLatch.await();
                long endTime=System.currentTimeMillis();//记录结束时间
                System.out.println("------统计指标全部完成--------");
//                System.out.println("统计结果为："+map.toString());
                System.out.println("任务总执行时间为"+(endTime-startTime)/1000+"秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public static  int setNum(int num){
            num = num+1;
            return num;
        }
        static class MyThreadDemo implements Runnable{
            private int  num;
            MyThreadDemo(int num){
                this.num = num;
            }
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "在运行" + System.currentTimeMillis());
                try {
                    Thread.sleep(500);
                    num = setNum(num);
                    System.out.println("当前线程序号"+num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
