package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author ryanw
 */
@SpringBootApplication
@EnableCaching // 开启缓存功能
public class Springboot21CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot21CacheApplication.class, args);
    }
}
