package com.itheima.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    // 声明队列
    @Bean
    public Queue objectQueue() {
        return new Queue("object.queue");
    }

}
