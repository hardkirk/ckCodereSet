package com.example;

import com.cloud.entity.Payment;
import com.example.service.impl.ThreadDemo;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/3 16:06
 * @Params DoInsetTest
 */
@Transactional
public class DoInsetTest {
    @Resource
    private ThreadDemo threadDemo2;
//    @Resource
//    private static DoInsertService doInsertService;
//
//    public static void main(String[] args) {
//        doInsertService.B(3);
//    }
    class MythreadTest implements Runnable{
    private ThreadDemo threadDemo;
    private Long num;
    MythreadTest(ThreadDemo threadDemo,Long num){
        this.threadDemo =threadDemo;
        this.num = num;
    }
    @Override
    public void run() {
        Payment payment = threadDemo.getPayment(num);
        System.out.println("当前获取id为："+num+"状态为"+payment.getSerial());
    }
}

    @Test
    void testThreadPool(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(6), Executors.defaultThreadFactory(),
                new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());
        ThreadDemo  demo = new ThreadDemo();
        for (int i = 1; i < 33; i++) {
            threadPoolExecutor.submit(new MythreadTest(demo,Long.valueOf(i)));
        }
    }

}
