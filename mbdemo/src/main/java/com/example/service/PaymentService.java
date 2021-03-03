package com.example.service;

import com.example.entity.Payment;

/**
 * @Author ChuK
 * @create 2021/2/5 17:16
 */
public interface PaymentService {
    Payment findPaymentById(Long id);
    void updatePaymentById(Payment payment);
}
