package com.example.demo.threadPool;

/**
 * @description:
 * @author: Chuk
 * @time: 2020/12/23 9:16
 * @Params TaskList
 */
public class TaskList implements Runnable{
    private int threadSum;

    public TaskList(int num){
        this.threadSum = num;
    }

    @Override
    public void run() {
        System.out.println(threadSum + "号 开始线程");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadSum+"号 线程执行完毕");
    }
}
