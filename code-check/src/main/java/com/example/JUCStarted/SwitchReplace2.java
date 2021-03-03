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
public class SwitchReplace2 {
    public static void main(String[] args) {
        AlternationDemo alternation = new AlternationDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                alternation.loopA();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternation.loopB();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternation.loopC();
                }
            }
        },"C").start();
    }

}
class AlternationDemo{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void loopA(){
        lock.lock();
        try {
            if (number != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName());
            number =2;
            condition2.signal();
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
    public void loopB(){
        lock.lock();
        try {
            if (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName());
            number =3;
            condition3.signal();
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
    public void loopC(){
        lock.lock();
        try {
            if (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName());
            number =1;
            condition1.signal();
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
}