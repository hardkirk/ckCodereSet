package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.dao")
@ComponentScan(value = "com.example")
public class MbdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MbdemoApplication.class, args);
    }

}
