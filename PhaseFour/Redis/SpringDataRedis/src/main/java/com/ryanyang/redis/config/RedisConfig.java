package com.ryanyang.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
    // 方法参数RedisConnectionFactory是一个连接工厂，用于创建与Redis服务器的连接。
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 创建RedisTemplate对象, 这个实例用于操作Redis数据库。
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置连接工厂, 将连接工厂设置到模板中，这是必需的，因为它定义了如何连接到Redis服务器。
        template.setConnectionFactory(redisConnectionFactory);
        // 设置JSON序列化工具, 用于将Java对象转换为JSON字符串，这样它们就可以存储在Redis中。
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        // 设置Key的序列化, 在这里，键被序列化为字符串。
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置Value的序列化, 使用前面创建的JSON序列化器，这允许将复杂的Java对象作为JSON存储。
        template.setValueSerializer(jsonRedisSerializer);
        template.setHashValueSerializer(jsonRedisSerializer);
        // 返回
        return template;
    }
}
