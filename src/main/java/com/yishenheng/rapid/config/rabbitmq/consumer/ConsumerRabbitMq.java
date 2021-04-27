package com.yishenheng.rapid.config.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * work模式，能者多劳。关闭自动确认消息，改成手动确认
 * 多个工人干同一件事情
 *
 * @author yishenheng
 * @date 4/22/21 8:49 PM
 */
@Component
public class ConsumerRabbitMq {


    @RabbitListener(queues = "directQueue")
    public void monitorMessage1(String messageStr, Message message, Channel channel) throws IOException {
        System.out.println("消费者1：" + messageStr);

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(queues = "directQueue")
    public void monitorMessage(String messageStr, Message message, Channel channel) throws IOException {
        try {
            Thread.sleep(2000);
            System.out.println("消费者2:" + messageStr);
            // 手动确认
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            System.out.println("消费者2出现异常。" + e.getMessage());
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);

        }
    }
}
