package com.itheima.consumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author ryanw
 */
@Component
@Slf4j
public class SpringRabbitListener {

    // 注解指定监听的目标队列
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String message) {
        // 处理业务
        log.info("监听到simple.queue的消息: ${}", message);
    }

    // 消费者1
    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String message) {
        System.out.println("消费者1接收到消息：" + message + ", " + LocalDateTime.now());
    }

    // 消费者2
    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String message) {
        // 打印出来是红的
        System.err.println("消费者2接收到消息：" + message + ", " + LocalDateTime.now());
    }

}
