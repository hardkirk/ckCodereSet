package com.example.JUCStarted;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/26 17:41
 * @Params ReadWriterLockDemo
 */
public class ReadWriterLockDemo {
    public static void main(String[] args) {
        ReadWriteLockTest writeLockTest = new ReadWriteLockTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                writeLockTest.set();
            }
        });

    }

    static class ReadWriteLockTest{
        private int number = 0;
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        //读  可以多个线程同时操纵
        public void get(){
            readWriteLock.readLock().lock();//上锁
            try {
                System.out.println(Thread.currentThread().getName() + ":" + number);
            }finally {
                readWriteLock.readLock().unlock();
            }
        }
        public void set(){
            readWriteLock.writeLock().lock();
            try{
                System.out.println(Thread.currentThread().getName());
                this.number = number;
            }finally {
                readWriteLock.writeLock().unlock();
            }
        }

    }
}
