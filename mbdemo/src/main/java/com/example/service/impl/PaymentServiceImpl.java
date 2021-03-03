package com.example.service.impl;

import com.example.dao.PaymentMapper;
import com.example.entity.Payment;
import com.example.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/5 17:17
 * @Params PaymentServiceImpl
 */
@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentMapper paymentMapper;

    @Override
    public Payment findPaymentById(Long id) {
        Payment payment = paymentMapper.selectById(id);
        return payment;
    }

    @Override
    public void updatePaymentById(Payment payment) {
        paymentMapper.updateById(payment);
    }


}
