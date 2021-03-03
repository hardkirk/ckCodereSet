package com.example.demo.threadPool.thread;

/**
 * @Author chuke
 * @create 2020/11/23 19:04
 */
public class valateDemo {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println("线程1号线开始，执行");
            long num = 0;
            while (!flag){
                num++;
            }
            System.out.println("num"+num);
        }).start();

        Thread.sleep(1000);
        new Thread(()->{
            System.out.println("2号线程启动，改变变量");
            setStop();

        }).start();

    }
    private static void setStop(){
        flag = true;
    }
}
