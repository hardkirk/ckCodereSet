package com.example.demo.threadPool;

import java.util.concurrent.*;

/**
 * @description:
 * @author: Chuk
 * @time: 2020/12/23 9:20
 * @Params ThreadPoolTest2
 */
public class ThreadPoolTest2 {
    private final static ExecutorService EXECUTOR_SERVICE =
            new ThreadPoolExecutor(2,3,20, TimeUnit.DAYS,new LinkedBlockingDeque<>(50));
    public void testThreadPool() throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            TaskList taskList = new TaskList(i);

            Future<?> submit = EXECUTOR_SERVICE.submit(taskList);
            System.out.println(i+"号线程开始,核心线程数"+((ThreadPoolExecutor) EXECUTOR_SERVICE).getCorePoolSize()
                    +"，激活线程数"+((ThreadPoolExecutor) EXECUTOR_SERVICE).getActiveCount()+",线程池大小"
                    +((ThreadPoolExecutor) EXECUTOR_SERVICE).getPoolSize());
            Thread.sleep(500);
        }
        EXECUTOR_SERVICE.shutdown();

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTest2 poolTest2 = new ThreadPoolTest2();
        poolTest2.testThreadPool();
    }
}
