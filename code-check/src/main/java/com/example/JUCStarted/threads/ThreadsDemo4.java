package com.example.JUCStarted.threads;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/3/3 14:25
 * @Params ThreadsDemo4
 */
public class ThreadsDemo4 {
        //加上volatile 和不加volatile 效果非常明显
         static int a=1;
         static int b = 0;
        public static void main(String[] args) throws InterruptedException {

            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"线程启动了");
                    while(true) {
                        System.out.println("线程一持续执行"+b);
                        b++;
                        //当a=3 跳出死循环
                        if(a==3) {
                            break;
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"线程停止了");
                }
            },"t2").start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"线程启动了");
                    while(true) {
                        System.out.println("线程二持续执行"+b);
                        b++;
                        //当a=3 跳出死循环
                        if(a==3) {
                            break;
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"线程停止了");
                }
            },"t1").start();
            //sleep 的目的就是让上面两个线程都启动起来
            Thread.sleep(1000);
            //在主线程里边修改变量，测试其他线程是否对这个修改可见
            System.out.println("现在修改这个值");
            a=3;
        }



}
