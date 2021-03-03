package com.example.JUCStarted.threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/3/3 13:43
 * @Params ThreadsDemo2
 */
public class ThreadsDemo2 {
    public static class VolatileAtomicThread implements Runnable {
        // 定义一个int类型的遍历
        private int count = 0;

        @Override
        public void run() {
            //对该变量进行++操作，100次
            for (int x = 0; x < 100; x++) {
                count++;
                System.out.println("count =========>>>> " + count);
            }
        }
    }

    public static void main(String[] args) {
        //创建VolatileAtomicThread对象V
        VolatileAtomicThread volatileAtomicThread = new VolatileAtomicThread();
        //开启100个线程对count进行++操作
        for (int x = 0; x < 100; x++) {
            new Thread(volatileAtomicThread).start();
        }
    }


}
