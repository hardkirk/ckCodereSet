package com.example.JUCStarted;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @description:将普通变量升级为原子变量
 * @author: Chuk
 * @time: 2021/2/23 11:39
 * @Params AtomicIntegerDemo
 */
public class AtomicIntegerDemo implements Runnable{
        static Goods phone;
        static Goods computer;

        AtomicIntegerFieldUpdater<Goods> atomicIntegerFieldUpdater =
                AtomicIntegerFieldUpdater.newUpdater(Goods.class, "price");

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                //一个是原子类，一个是普通类，这里区分
                phone.price++;
                atomicIntegerFieldUpdater.getAndIncrement(computer);
            }
        }

        static class Goods {
            //商品定价
            volatile int price;
        }

        public static void main(String[] args) throws InterruptedException {
            phone = new Goods();
            computer = new Goods();
            AtomicIntegerDemo atomicIntegerFieldUpdaterTest = new AtomicIntegerDemo();
            Thread thread1 = new Thread(atomicIntegerFieldUpdaterTest);
            Thread thread2 = new Thread(atomicIntegerFieldUpdaterTest);
            thread1.start();
            thread2.start();
            //join()方法是为了让main主线程等待thread1、thread2两个子线程执行完毕
            thread1.join();
            thread2.join();
            System.out.println("CommonInteger price = " + phone.price);
            System.out.println("AtomicInteger price = " + computer.price);
        }

}
