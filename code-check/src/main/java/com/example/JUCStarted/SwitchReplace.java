package com.example.JUCStarted;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/23 18:48
 * @Params SwitchReplace
 */
public class SwitchReplace {
    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public static void main(String[] args)  {
        SwitchReplace useCase = new SwitchReplace();
        ExecutorService executorService = Executors.newFixedThreadPool (2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                useCase.conditionWait();
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                useCase.conditionSignal();
            }
        });
    }

    public void conditionWait()  {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到锁了1");
            System.out.println(Thread.currentThread().getName() + "等待信号1");
            condition.await();
            System.out.println(Thread.currentThread().getName() + "拿到信号1");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    public void conditionSignal() {
        lock.lock();
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "拿到锁了2");
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "发出信号2");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
