package com.example.JUCStarted;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/23 14:38
 * @Params TestLock
 */
public class TestLock {

    public static void main(String[] args) {
        Ticket td = new Ticket();
        new Thread(td,"窗口1").start();
        new Thread(td,"窗口2").start();
        new Thread(td,"窗口3").start();
        new Thread(td,"窗口4").start();
    }
    static class Ticket implements Runnable{
        private int ticket = 100;
        @Override
        public void run() {
            while (true){
                if (ticket >0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为"+(--ticket));
                }
            }
        }
    }
}
