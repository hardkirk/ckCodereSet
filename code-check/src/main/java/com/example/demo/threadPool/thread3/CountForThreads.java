package com.example.demo.threadPool.thread3;


import java.util.concurrent.*;

import static com.example.demo.threadPool.thread4.SynchronizedTest.changeNum;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/2 9:56
 * @Params CountForThreads
 */


    class MyTask implements Runnable {
        private  int count  =0;
        private Integer aid;

        public MyTask(Integer aid) {
            this.aid = aid;
        }

        public  void run() {

                System.out.println("线程开始了");
                try {
                    int i = changeNum(aid);
                    Thread.sleep(500);
                    count = changeNum(count);
                    System.out.println("----------计数器："+count+"--------线程值-"+aid+"----------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("出错了");
                }



            }
//    public synchronized static int changeNum(int y){
//        int b = y++;
//        System.out.println("线程结束了" + b);
//        return b;
//    }

    }

    public class CountForThreads {

        public static void main(String[] args) {
            ExecutorService es = new ThreadPoolExecutor(4, 4, 10, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(50), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.CallerRunsPolicy());
//            ExecutorService es  =
//                    new ThreadPoolExecutor(4,9,20, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(50));
//            MyTask t1 = new MyTask("id:1");
//            MyTask t2 = new MyTask("id:2");
//            MyTask t3 = new MyTask("id:3");
//            MyTask t4 = new MyTask("id:4");
//            MyTask t5 = new MyTask("id:5");
//            MyTask t6 = new MyTask("id:6");
//            MyTask t7 = new MyTask("id:7");
//            MyTask t8 = new MyTask("id:8");
//            MyTask t9 = new MyTask("id:9");
//            MyTask t10 = new MyTask("id:10");
//            MyTask t11 = new MyTask("id:11");
//            MyTask t12 = new MyTask("id:12");
//            MyTask t13 = new MyTask("id:13");
            for (int i = 0; i < 100; i++) {

                es.submit(new MyTask(i));
//                es.execute(new MyTask(i));
//                System.out.println("线程池数量"+((java.util.concurrent.ThreadPoolExecutor) es).getPoolSize());
//                System.out.println("队列长度"+((java.util.concurrent.ThreadPoolExecutor) es).getQueue().size());
//                System.out.println("核心线程数"+((java.util.concurrent.ThreadPoolExecutor) es).getCorePoolSize());
//                System.out.println("线程id"+((java.util.concurrent.ThreadPoolExecutor) es).);
            }
            System.out.println("!!!!!!!!!!!!!!!!!!!");


        }
    }


