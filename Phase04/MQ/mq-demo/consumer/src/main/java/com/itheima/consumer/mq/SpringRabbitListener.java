package com.itheima.consumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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

}
