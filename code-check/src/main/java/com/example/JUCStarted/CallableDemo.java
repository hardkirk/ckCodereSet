package com.example.JUCStarted;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/23 14:18
 * @Params CallableDemo
 */
public class CallableDemo {
    /**
     * 现在Callable接口和实现Runable接口的区别就是，Callable带泛型，其call方法有返回值。
     * 使用的时候，需要用FutureTask来接收返回值。而且它也要等到线程执行完调用get方法才会执行，
     * 也可以用于闭锁操作
     */
    public static void main(String[] args) {
        CallablTest callablTest = new CallablTest();

        FutureTask<Integer> result = new FutureTask<>(callablTest);
        new Thread(result).start();

        try {
            Integer sum = result.get();
            System.out.println(sum);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class CallablTest implements Callable<Integer> {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum +=i;
                }
                return sum;
            }
        }
    }
