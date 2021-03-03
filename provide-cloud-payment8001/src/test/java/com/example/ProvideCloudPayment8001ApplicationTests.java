package com.example;

import com.example.transational.TestSetTransation2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProvideCloudPayment8001ApplicationTests {

    @Test
    void contextLoads() {
        TestSetTransation2 testSetTransation2 = new TestSetTransation2();
        testSetTransation2.changeDetail2();
    }

}
