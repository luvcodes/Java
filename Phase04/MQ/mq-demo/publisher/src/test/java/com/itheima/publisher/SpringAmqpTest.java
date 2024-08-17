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
     * 对应WorkQueue队列
     * 发送者 对应消费者1、2 的 workqueue
     */
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

    /**
     * 对应fanout交换机
     * 发送者 对应fanout消费者1、2 的 fanout queue
     * 这里是用的fanout交换机
     */
    @Test
    public void testFanoutQueue() {
        // 1. 交换机名，这个就是在rabbitMQ控制台定义的交换机名
        String exchangeName = "hmall.fanout";
        // 2. 消息
        String message = "hello, fanout everyone";
        // 3. 发送消息
        rabbitTemplate.convertAndSend(exchangeName, null, message);
    }

    /**
     * 对应direct交换机
     * 发送者 对应direct消费者1、2的direct queue
     * 这里使用的direct交换机
     * */
    @Test
    public void testDirectQueue() {
        String queueName = "hmall.direct";
        String message = "红色警报！";
        rabbitTemplate.convertAndSend(queueName, "red", message);
    }

    /**
     * 对应Topic交换机
     * */
    @Test
    public void testSendTopicExchange() {
        String exchangeName = "hmall.topic";
        String message = "hello, topic";
        rabbitTemplate.convertAndSend(exchangeName, "china.news", message);
    }

}
