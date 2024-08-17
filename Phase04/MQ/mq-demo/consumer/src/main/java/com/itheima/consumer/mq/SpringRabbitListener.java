package com.itheima.consumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author ryanw
 */
@Component
@Slf4j
public class SpringRabbitListener {

    // 这个注解用来指定需要监听的目标队列。这是为了体现单队列、单消费者的最简单的情况
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String message) {
        // 处理业务
        log.info("监听到simple.queue的消息: ${}", message);
    }

    /**
     * WorkQueues模型
     * */
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

    /**
     * fanout交换机，特性是所有的队列都能收到消息
     * fanout消费者1
     * */
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String message) {
        log.info("消费者1监听到 fanout.queue1的消息: {}", message);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String message) {
        log.info("消费者2监听到 fanout.queue2的消息: {}", message);
    }

    /**
     * Direct交换机：根据routing key指定性的收到消息
     * 下面这两个是对应的RabbitMQ的控制台，分别指定了routing key
     * - blue、red routing key 1
     * - red、yellow routing key 2
     * 因此，在SpringAmqpTest测试类里指定routing key为red，这里两个消费者都能收到
     * */
    // direct消费者1
    // @RabbitListener(queues = "direct.queue1")
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1", durable = "true"),
            exchange = @Exchange(name = "hmall.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void listenDirectQueue1(String msg) {
        System.out.println("消费者1接收到direct.queue1的消息：【" + msg + "】");
    }

    // direct消费者2
    // @RabbitListener(queues = "direct.queue2")
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2", durable = "true"),
            exchange = @Exchange(name = "hmall.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listenDirectQueue2(String msg) {
        System.out.println("消费者2接收到direct.queue2的消息：【" + msg + "】");
    }

    /**
     * Topic交换机：Direct交换机的升级版，可以指定通配符
     * */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "hmall.topic", type = ExchangeTypes.TOPIC),
            key = "china.#"
    ))
    // @RabbitListener(queues = "topic.queue1")
    public void listenTopicQueue1(String msg){
        System.out.println("消费者1接收到topic.queue1的消息：【" + msg + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "hmall.topic", type = ExchangeTypes.TOPIC),
            key = "#.news"
    ))
    // @RabbitListener(queues = "topic.queue2")
    public void listenTopicQueue2(String msg){
        System.out.println("消费者2接收到topic.queue2的消息：【" + msg + "】");
    }

}
