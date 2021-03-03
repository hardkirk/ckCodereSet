package com.example.test;

import com.example.entity.Payment;
import com.example.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/5 17:36
 * @Params PaymentTesrDemo
 */

public class PaymentTesrDemo {
    @Autowired
    private  PaymentService paymentService;

    public void justonemoretime() {
        for (int i = 1; i < 33; i++) {
            Payment paymentById = paymentService.findPaymentById(Long.valueOf(i));
            System.out.println("id为"+paymentById.getId()+"  值为"+paymentById.getSerial());
        }
    }


}
