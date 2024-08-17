package com.itheima.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfiguration {

    /**
     * 声明交换机
     * */
    @Bean
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange("hmall.direct").build();
    }

    /**
     * 声明第一个队列
     * */
    @Bean
    public Queue directQueue1() {
        return QueueBuilder.durable().build();
    }

    /**
     * 绑定第一个队列和交换机
     * */
    @Bean
    public Binding bindingQueue1WithRed(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("red");
    }

    /**
     * 声明第一个队列
     * */
    @Bean
    public Queue directQueue2() {
        return QueueBuilder.durable().build();
    }

    /**
     * 绑定第一个队列和交换机
     * */
    @Bean
    public Binding bindingQueue2WithRed(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("yellow");
    }



}
