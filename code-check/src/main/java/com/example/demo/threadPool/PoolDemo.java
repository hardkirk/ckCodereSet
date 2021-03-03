package com.example.demo.threadPool;

import lombok.AllArgsConstructor;

import java.util.concurrent.*;

/**
 * @Author chuke
 * @create 2020/8/24 21:46
 */
@AllArgsConstructor
public class PoolDemo {
    private final static ExecutorService EXECUTOR_SERVICE =
            new ThreadPoolExecutor(4,4,20,TimeUnit.DAYS,new LinkedBlockingDeque<>(50));

    /**
     * corePoolSize（线程池基本大小）
     * maximumPoolSize（线程池最大大小）
     * keepAliveTime（线程存活保持时间）
     * workQueue（任务队列）new LinkedBlockingDeque<Runable>() 无阻塞队列
     * threadFactory（线程工厂）
     * handler（线程饱和策略）
     */
   /* public ThreadPoolExecutor(int corePoolSize,
                                 int maximumPoolSize,
                                 long keepAliveTime,
                                 TimeUnit unit,
                                 BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                Executors.defaultThreadFactory(), defaultHandler);
    }*/
   //预定义线程池
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
    /**最大线程数与核心线程数的数量一致，是一个固定大小的线程池，*/

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }

}
