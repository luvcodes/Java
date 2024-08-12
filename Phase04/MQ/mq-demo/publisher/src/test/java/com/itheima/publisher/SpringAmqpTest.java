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

    /**
     * 发送者 对应消费者1、2 的 workqueue
     * */
    @Test
    public void testWorkQueue() {
        // 1. 队列名
        String queueName = "work.queue";
        for (int i = 0; i <= 50; i++) {
            // 2. 消息
            String message = "hello, spring amqp_" + i;
            // 3. 发送消息
            rabbitTemplate.convertAndSend(queueName, message);
        }
    }
}
