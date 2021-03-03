package com.example.demo.threadPool.thread;

import org.apache.tomcat.jni.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author chuke
 * @create 2020/11/19 19:26
 */
public class RunableDemo {
    public static void main(String[] args) {
        TicketLockDemo demo = new TicketLockDemo();
        Thread thread1 = new Thread(demo,"小孩");
        Thread thread2 = new Thread(demo,"小人");
        Thread thread3 = new Thread(demo,"faf1");
        thread2.setPriority(8);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class TicketLockDemo implements Runnable{
    int ticketNum = 8852;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        try{
            while(true){
                if (ticketNum>0) {
                    System.out.println(Thread.currentThread().getName()+"还剩下" + ticketNum + "张票");
                    ticketNum--;
                }
                else
                    break;
            }
        }finally {
            lock.unlock();
        }

    }
}
