package com.example.service;

import com.cloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author chuke
 * @create 2020/8/4 18:59
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}

