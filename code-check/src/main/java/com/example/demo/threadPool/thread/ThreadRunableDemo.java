package com.example.demo.threadPool.thread;

/**
 * @Author chuke
 * @create 2020/11/18 20:15
 */
public class ThreadRunableDemo implements Runnable{
    private int ticketNums = 10;
    @Override
    public void run() {
        for (int i = 0; i < ticketNums; i++) {


        if (ticketNums!=0){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"->拿到了"+ticketNums+"票");
        }

        ticketNums --;
        }
    }

    public static void main(String[] args) {
        ThreadRunableDemo demo = new ThreadRunableDemo();
        Thread thread3 = new Thread(demo,"狗");
        Thread thread1 = new Thread(demo,"猫");
        Thread thread2 = new Thread(demo,"人");
        thread3.start();
        thread2.start();
        thread1.start();
    }
}
