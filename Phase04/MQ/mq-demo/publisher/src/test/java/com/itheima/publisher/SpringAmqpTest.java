package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleQueue() {

        // 1. 队列名
        String queueName = "simple.queue";

        // 2. 消息内容
        String message = "hello, mq";

        // 3. 发送消息
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
