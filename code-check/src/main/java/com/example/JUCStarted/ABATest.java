package com.example.JUCStarted;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/23 15:20
 * @Params ABATest
 */
public class ABATest {
    public static AtomicReference<Integer> atomicReference=new AtomicReference<>(100);

    public static void main(String[] args) {
        System.out.println("------------ABA问题的产生----------------");
        new Thread(()->{
            //100改101再改回100
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(()->{
            //暂停1s，保证上面的t1完成一次ABA操作
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();}
            //对比预期值是否跟原址一样，只看结果值，不看过程
            System.out.println("查看结果"+atomicReference.get());
            System.out.println(atomicReference.compareAndSet(100,2019)+"---"+atomicReference.get());;
        },"t2").start();
    }
}
