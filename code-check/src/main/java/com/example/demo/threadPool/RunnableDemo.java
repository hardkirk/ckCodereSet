package com.example.demo.threadPool;

import java.util.concurrent.*;

/**
 * @Author chuke
 * @create 2020/9/3 21:53
 */
public class RunnableDemo implements Runnable{
    private final static ExecutorService ExecutorService =
            new ThreadPoolExecutor(2,3,60, TimeUnit.MINUTES,new LinkedBlockingDeque<Runnable>());

    /**
     * LinkedBlockingDeque双向阻塞队列
     *
     * 特有方法：
     * LinkedBlockingDeque多了addFirst、addLast、peekFirst、peekLast等方法，
     * 以first结尾的方法，表示插入、获取获移除双端队列的第一个元素。
     * 以last结尾的方法，表示插入、获取获移除双端队列的最后一个元素。
     *
     *LinkedBlockingDeque类对元素的操作方法比较多，
     * 我们下面以putFirst、putLast、pollFirst、pollLast方法来对元素的入队、出队操作进行分析。
     */
    @Override
    public void run() {
        System.out.println("something start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("something restart");
    }

    public static void main(String[] args) {
        ExecutorService threadService = Executors.newFixedThreadPool(2);//包含两个线程对象
        //使用runnable创建实例对象
        RunnableDemo r = new RunnableDemo();
        //或者使用thread创建线程
//        Thread t = new Thread();
//        t.start();
        //从线程池中获取线程对象
        threadService.submit(r);
        //调用完毕后，程序并不终止，线程池控制了线程的开关
//        threadService.shutdownNow();线程池关闭
    }
}
