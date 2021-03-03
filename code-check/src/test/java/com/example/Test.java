package com.example;

import com.example.entity.BankTemplateIdEnum;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author chuke
 * @create 2020/8/8 14:12
 */
@SpringBootTest
public class Test {
    public static void main(String[] args) {
        System.out.println(BankTemplateIdEnum.ICBCDel.getDesc());
    }
}
