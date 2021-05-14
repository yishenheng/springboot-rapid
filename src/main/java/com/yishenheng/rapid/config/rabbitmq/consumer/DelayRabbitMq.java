package com.yishenheng.rapid.config.rabbitmq.consumer;

import cn.hutool.core.date.DateUtil;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author yishenheng
 * @date 5/13/21 6:07 PM
 */
@Component
@Slf4j
public class DelayRabbitMq {


    @RabbitListener(queues = "delayQueue")
    public void receive(String json, Message message, Channel channel) throws IOException {
        log.info("json:{}，消费时间:{}", json, DateUtil.now());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
