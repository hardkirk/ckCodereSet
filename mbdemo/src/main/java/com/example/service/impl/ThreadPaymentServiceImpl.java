package com.example.service.impl;

import com.example.entity.Payment;
import com.example.service.PaymentService;
import com.example.service.ThreadPaymentService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/5 18:41
 * @Params ThreadPaymentServiceImpl
 */
@Service
@AllArgsConstructor
public class ThreadPaymentServiceImpl implements ThreadPaymentService {
    private final PaymentService paymentService;
    private static final ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(),
            new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());

    @Override
    public void soluactionThread(String status) {
//        for (int i = 1; i < 90; i++) {
            Payment payment = paymentService.findPaymentById(Long.valueOf(1));
            Payment payment2 = paymentService.findPaymentById(Long.valueOf(2));
            Payment payment3 = paymentService.findPaymentById(Long.valueOf(2));
            Payment payment4 = paymentService.findPaymentById(Long.valueOf(2));
            payment.setStatus(status);
            threadPoolExecutor.submit(new UpdateRunner(payment));
            threadPoolExecutor.submit(new UpdateRunner(payment2));
            threadPoolExecutor.submit(new UpdateRunner(payment3));
            threadPoolExecutor.submit(new UpdateRunner(payment4));
//        }
    }

    @AllArgsConstructor
    class UpdateRunner implements Runnable{
        private Payment payment;

        @Override
        public void run() {
            paymentService.updatePaymentById(payment);
        }
    }
}
