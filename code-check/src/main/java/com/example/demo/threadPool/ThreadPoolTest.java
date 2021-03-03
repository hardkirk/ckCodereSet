package com.example.demo.threadPool;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * @description:
 * @author: Chuk
 * @time: 2020/12/23 9:09
 * @Params ThreadPoolTest
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for(int i=0;i<50;i++){

            Task task = new Task(i);

            executor.execute(task);

            System.out.println("线程池中线程数:" + executor.getPoolSize() + ",队列中等待执行的任务数:" + executor.getQueue().size() +

                    ",已执行完的任务数:" + executor.getCompletedTaskCount());

            Thread.currentThread().sleep(500);

        }

        executor.shutdown();

    }

}

class Task implements Runnable {

    private int taskNum;

    public Task(int num) {

        this.taskNum = num;

    }

    @Override

    public void run() {

        System.out.println("task"+taskNum+"开始执行");

        try{

            Thread.currentThread().sleep(4000);

        }catch(InterruptedException e){

            e.printStackTrace();

        }

        System.out.println("task"+taskNum+"执行完毕");

    }
}
