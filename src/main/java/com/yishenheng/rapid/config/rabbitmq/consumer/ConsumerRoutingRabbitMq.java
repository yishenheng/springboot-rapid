package com.yishenheng.rapid.config.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 路由消费
 *
 * @author yishenheng
 * @date 5/7/21 4:30 PM
 */
@Component
public class ConsumerRoutingRabbitMq {

    @RabbitListener(queues = "#{directQueue1.name}")
    public void printInfoA(String json) {
        System.out.println("A" + json);
    }

    @RabbitListener(queues = "#{directQueue2.name}")
    public void printInfoBC(String json) {
        System.out.println("BC" + json);
    }
}
