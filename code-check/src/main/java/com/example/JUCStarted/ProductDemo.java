package com.example.JUCStarted;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/23 16:32
 * @Params ProductDemo
 */
public class ProductDemo {
        public static void main(String[] args){
            Clerk clerk = new Clerk();
            Productor productor = new Productor(clerk);
            Consumer consumer = new Consumer(clerk);
            new Thread(productor,"生产者A").start();
            new Thread(consumer,"消费者B").start();
        }
    }
    //店员
    class Clerk{
        private int product = 0;//共享数据
        public synchronized void get(){ //进货
            while (product >=10){
                System.out.println("产品已满");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.println(Thread.currentThread().getName()+":"+ (++product));
                this.notifyAll();//没满就可以进货

        }
        public synchronized void sell(){//卖货
            while (product <= 0){
                System.out.println("缺货");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.println(Thread.currentThread().getName()+":"+ (--product));
                this.notifyAll();//没满就可以进货

        }
    }
    //生产者
    class Productor implements Runnable{
        private Clerk clerk;
        public Productor(Clerk clerk){
            this.clerk = clerk;
        }
        @Override
        public void run() {
            for (int i = 0;i<20;i++){
                clerk.get();
            }
        }
    }
    //消费者
    class Consumer implements Runnable{
        private Clerk clerk;
        public Consumer(Clerk clerk){
            this.clerk = clerk;
        }
        @Override
        public void run() {
            for (int i = 0;i<20;i++){
                clerk.sell();
            }
        }
    }

