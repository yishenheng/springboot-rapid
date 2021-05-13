package com.yishenheng.rapid.config.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.yishenheng.rapid.constant.DeadLetterConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author yishenheng
 * @date 5/12/21 5:49 PM
 */
@Component
@Slf4j
public class DeadLetterRabbitMq {

    @RabbitListener(queues = DeadLetterConstant.BUSINESS_QUEUEA_NAME)
    public void printInfoA(String json, Message message, Channel channel) throws IOException {
        log.info("手动nack的消息：{}", json);
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);

    }

    @RabbitListener(queues = DeadLetterConstant.BUSINESS_QUEUEB_NAME)
    public void printInfoB(String json, Message message, Channel channel) throws IOException {
        log.info("正常消费的消息:{}", json);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(queues = DeadLetterConstant.DEAD_LETTER_QUEUEA_NAME)
    public void deadLetterInfo(String json, Message message, Channel channel) throws IOException {
        log.info("死信队列消费的消息:{}", json);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
