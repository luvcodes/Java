package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot15ConfigurationApplicationTests {
    @Value("${servers.ip-address}")
    private String message;

    @Test
    void contextLoads() {
        System.out.println(message);
    }
}
