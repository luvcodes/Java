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

    // 这个注解用来指定需要监听的目标队列
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

    // fanout消费者1
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String message) {
        log.info("消费者1监听到 fanout.queue1的消息: {}", message);
    }

    // fanout消费者2
    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String message) {
        log.info("消费者2监听到 fanout.queue2的消息: {}", message);
    }

    /**
     * 下面这两个是对应的RabbitMQ的控制台，分别指定了routing key
     * - blue、red routing key 1
     * - red、yellow routing key 2
     * 因此，在SpringAmqpTest测试类里指定routing key为red，这里两个消费者都能收到
     * */
    // direct消费者1
    @RabbitListener(queues = "direct.queue1")
    public void listenDirectQueue1(String msg) {
        System.out.println("消费者1接收到direct.queue1的消息：【" + msg + "】");
    }

    // direct消费者2
    @RabbitListener(queues = "direct.queue2")
    public void listenDirectQueue2(String msg) {
        System.out.println("消费者2接收到direct.queue2的消息：【" + msg + "】");
    }

}
