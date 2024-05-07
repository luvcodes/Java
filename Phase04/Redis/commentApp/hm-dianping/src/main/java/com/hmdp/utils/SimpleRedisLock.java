package com.hmdp.utils;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author ryanw
 */
public class SimpleRedisLock implements ILock {

    // 根据业务变化的名称
    private String name;
    // 锁的前缀
    private static final String KEY_PREFIX = "lock:";
    private StringRedisTemplate stringRedisTemplate;

    public SimpleRedisLock(String name, StringRedisTemplate stringRedisTemplate) {
        this.name = name;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 尝试获取锁
     *
     * @param timeoutSec 锁持有的超时时间，过期后自动释放
     * @return true代表获取锁成功，false代表获取锁失败
     */
    @Override
    public boolean tryLock(long timeoutSec) {
        // 获取线程标示, 也就是thread1这个值
        long threadId = Thread.currentThread().getId();

        // 获取锁，这种写法就是redis中的setnx写法，指定仅在键不存在时才设置该键，其实就是加锁
        // 还指定了ex 过期时间
        // setnx lock thread1 nx ex time
        Boolean success = stringRedisTemplate.opsForValue().setIfAbsent(KEY_PREFIX + name, threadId+"", timeoutSec, TimeUnit.SECONDS);

        // 这里不直接返回success的原因是因为方法返回值是boolean，而success是Boolean
        // 有自动拆箱的情况，存在风险。
        return Boolean.TRUE.equals(success);
    }

    /**
     * 释放锁
     */
    @Override
    public void unlock() {
        stringRedisTemplate.delete(KEY_PREFIX + name);
    }
}
