package com.hmdp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class RedissonClientTests {

    @Resource
    private RedissonClient redissonClient;

    private RLock rLock;

    @BeforeEach
    void setUp() {
        rLock = redissonClient.getLock("order");
    }

    @Test
    public void method1() {
        // 尝试获取锁
        boolean isLock = rLock.tryLock();
        if (!isLock) {
            log.error("获取锁失败...");
            return;
        }
        try {
            log.info("获取锁成功...1");
            method2();
            log.info("开始执行业务...1");
        } finally {
            log.warn("准备释放锁...1");
            rLock.unlock();
        }
    }

    @Test
    public void method2() {
        // 尝试获取锁
        boolean isLock = rLock.tryLock();
        if (!isLock) {
            log.error("获取锁失败");
        }
        try {
            log.info("获取锁成功...2");
            log.info("开始执行业务...2");
        } finally {
            log.warn("准备释放锁...2");
            rLock.unlock();
        }
    }
}
