package com.example.demo.threadPool.thread;

import lombok.SneakyThrows;

/**
 * @Author chuke
 * @create 2020/11/19 19:47
 */
public class ThreadDemcs {
    public static void main(String[] args) {
        Synchicken synchicken = new Synchicken();
        new Product(synchicken).start();
        new Customer(synchicken).start();
    }
}

class Product extends Thread{
    Synchicken containner;
    public Product(Synchicken containner){
        this.containner = containner;
    }

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            containner.push(new Chicken(i));
            System.out.println("消费了第"+i+"只鸡");
        }

    }
}
class Customer extends Thread{
    Synchicken contains;
    public Customer(Synchicken contains){
        this.contains = contains;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            contains.eat();
        }
    }
}
class Chicken{
    int id;

    public Chicken(int i) {
    }
}
//缓冲区
class Synchicken{

    Chicken[] chickens = new Chicken[10];
    int nums = 0;
    public synchronized void push(Chicken chicken){
        //容器满了，就等待消费者
        if (nums == chickens.length){
            System.out.println("已经满了，快点吃");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        //没有满，则丢入产品
        chickens[nums] = chicken;
        nums++;
        //唤醒线程
        this.notifyAll();
        System.out.println("鸡窝已经有了"+nums+"只鸡");
    }

    public synchronized Chicken eat() throws InterruptedException {
        //如果没有存货，就等待
        if (nums == 0){
            System.out.println("已经没了，赶紧的");
            this.wait();
        }
        //如果有，就进行消费
        nums--;
        Chicken chicken = chickens[nums];
        this.notifyAll();
        return chicken;
    }
}
