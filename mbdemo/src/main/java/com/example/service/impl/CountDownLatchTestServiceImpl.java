package com.example.service.impl;

import com.example.dao.PaymentMapper;
import com.example.entity.Payment;
import com.example.service.CountDownLatchTestService;
import com.example.service.ThreadPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/8 11:40
 * @Params CountDownLatchTestServiceImpl
 */
@Service
@AllArgsConstructor
public class CountDownLatchTestServiceImpl implements CountDownLatchTestService {
    private  final PaymentMapper paymentMapper;



//    public static void main(String[] args) {
    public void updateMain(){

        Thread update1Thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String s = updateTest1(1,30);
                System.out.println(s);
            }
        });
        Thread update1Thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String s = updateTest1(31,60);
                System.out.println(s);
            }
        });
        Thread update1Thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String s = updateTest1(61,90);
                System.out.println(s);
            }
        });
        Thread update1Thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                String s = updateTest1(91,120);
                System.out.println(s);

            }
        });
        update1Thread.start();
        update1Thread1.start();
        update1Thread2.start();
        update1Thread3.start();
    }

    public  String updateTest0(){
        for (int i = 1; i < 11; i++) {
            Payment payment = paymentMapper.selectById(Long.valueOf(i));
            payment.setStatus("a7");
            paymentMapper.updateById(payment);
        }
        String str = "完成了id小于： "+11+"的单据";
        return str;
    }
    public  String updateTest1(int start,int end){
        for (int i = start; i < end; i++) {
            Payment payment = paymentMapper.selectById(Long.valueOf(i));
            payment.setStatus("su");
            paymentMapper.updateById(payment);
        }
        String str = "完成了id从"+start+"到： "+end+"的单据";
        return str;
    }
//    public  String updateTest2(){
//        for (int i = 21; i < 31; i++) {
//            Payment payment = paymentMapper.selectById(Long.valueOf(i));
//            payment.setStatus("c7");
//            paymentMapper.updateById(payment);
//        }
//        String str = "完成了id小于： "+31+"的单据";
//        return str;
//    }
//    public  String updateTest3(){
//        for (int i = 31; i < 41; i++) {
//            Payment payment = paymentMapper.selectById(Long.valueOf(i));
//            payment.setStatus("d7");
//            paymentMapper.updateById(payment);
//        }
//        String str = "完成了id小于： "+41+"的单据";
//        return str;
//    }
}
