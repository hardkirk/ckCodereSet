package com.example.service.Impl;

import com.cloud.entity.Payment;
import com.example.dao.PaymentDao;
import com.example.service.DoInsertService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/3 14:49
 * @Params DoInsertServiceImpl
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class DoInsertServiceImpl implements DoInsertService {
    @Resource
    private PaymentDao paymentDao;

            public void B(int i){
                Payment user = new Payment();
                if (i==2){
                    user.setId(Long.valueOf(i));
                    user.setSerial("No"+i);
                    paymentDao.create(user);
                    int a = 1/0; //抛出ArithmeticException异常
                }else {
                    user.setId(Long.valueOf(i));
                    user.setSerial("No"+i);
                    paymentDao.create(user);
                }
            }


}


