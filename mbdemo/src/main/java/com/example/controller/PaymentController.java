package com.example.controller;

import com.example.condition.UpdatePaymentVo;
import com.example.entity.Payment;
import com.example.service.CountDownLatchTestService;
import com.example.service.PaymentService;
import com.example.service.ThreadPaymentService;
import com.example.until.CkResponseResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/5 17:48
 * @Params PaymentController
 */
@Slf4j
@RestController
@RequestMapping("/come")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final ThreadPaymentService threadPaymentService;
    private final CountDownLatchTestService downLatchTestService;
    private static CountDownLatch countDownLatch=new CountDownLatch(4);

    @GetMapping("/test01")
    public CkResponseResult testPayment(){
        for (int i = 1; i < 33; i++) {
            Payment paymentById = paymentService.findPaymentById(Long.valueOf(i));
            System.out.println("id为 "+paymentById.getId()+" 值是： "+paymentById.getSerial()+" -----状态为"+paymentById.getStatus());
        }

    return new CkResponseResult();
    }


    @PostMapping("/test02")
    public CkResponseResult updatePayment(@RequestBody UpdatePaymentVo vo){
//        for (int i = 1; i < 89; i++) {
            threadPaymentService.soluactionThread(vo.getStatus());
            Payment paymentById = paymentService.findPaymentById(Long.valueOf(5));
            System.out.println("id为 "+paymentById.getId()+" 值是： "+paymentById.getSerial()+" -----状态为"+paymentById.getStatus());
//        }
        return new CkResponseResult().setData("完成了");
    }
    @PostMapping("/test03")
    public CkResponseResult updateMain(){
        long startTime=System.currentTimeMillis();

        try {
            downLatchTestService.updateMain();
            countDownLatch.await();
            long endTime = System.currentTimeMillis();//记录结束时间
            System.out.println("------统计指标全部完成--------");
            System.out.println("任务总执行时间为" + (endTime - startTime) / 1000 + "秒");
        }catch (Exception e){
            System.out.println("出错了");
        }
        return new CkResponseResult();
    }
}
