package com.example.service.impl;


import com.cloud.entity.Payment;
import com.example.dao.PaymentDao;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/5 14:47
 * @Params ThreadDemo
 */
@Service
public class ThreadDemo {
    @Resource
    private static PaymentDao paymentDao;

    public static Payment getPayment(Long id){
        Payment payment = paymentDao.getPaymentById(id);
        System.out.println("本次查询的记录为"+payment);
        return payment;
    }

   static class MyThread2 implements Runnable{
        private Long id;
        MyThread2(Long id){
            this.id = id;
        }
        @Override
        public void run() {
            getPayment(id);
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(6), Executors.defaultThreadFactory(),
                new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 1; i < 33; i++) {
            threadPoolExecutor.submit(new MyThread2(Long.valueOf(i)));
        }
    }
}
