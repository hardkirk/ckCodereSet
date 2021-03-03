package com.example.transational;

import cn.hutool.core.lang.UUID;
import com.cloud.entity.Payment;
import com.example.dao.PaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/1/27 17:17
 * @Params TestSetTransation
 */
public class TestSetTransation {
    @Autowired
    private PaymentDao paymentDao;
    @Transactional
    public void changeDetail(){
        Long id = Long.valueOf(43112);
        Payment payment = new Payment();
        UUID uuid = UUID.randomUUID();
        payment.setSerial("ck"+uuid);
        paymentDao.create(payment);
    }
}
