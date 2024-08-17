package com.itheima.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfiguration {

    // 声明交换机
    @Bean
    public FanoutExchange fanoutExchange() {
        // return new FanoutExchange("hmall.fanout");
        return ExchangeBuilder.fanoutExchange("hmall.fanout").build();
    }

    // 声明队列
    @Bean
    public Queue fanoutQueue1() {
        // 1. 声明queue的第一种方式
        // return new Queue("hmall.fanout1");

        // 2. 第二种方式，基于builder
        return QueueBuilder.durable("fanout.queue1").build();
    }

    // 声明队列与交换机的绑定关系
    @Bean
    public Binding fanoutQueue1Binding(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    // 声明队列
    @Bean
    public Queue fanoutQueue2() {
        // 1. 声明queue的第一种方式
        // return new Queue("hmall.fanout1");

        // 2. 第二种方式，基于builder
        return QueueBuilder.durable("fanout.queue2").build();
    }

    // 声明队列与交换机的绑定关系
    @Bean
    public Binding fanoutQueue2Binding(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
