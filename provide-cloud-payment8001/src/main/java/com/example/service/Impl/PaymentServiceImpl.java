package com.example.service.Impl;

import com.cloud.entity.Payment;
import com.example.dao.PaymentDao;
import com.example.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author chuke
 * @create 2020/8/4 18:59
 */
@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create((payment));
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }


}
