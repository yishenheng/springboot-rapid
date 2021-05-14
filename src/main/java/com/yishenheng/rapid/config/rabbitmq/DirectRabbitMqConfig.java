package com.yishenheng.rapid.config.rabbitmq;

import com.yishenheng.rapid.constant.DeadLetterConstant;
import com.yishenheng.rapid.constant.RabbitMqConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * RabbitMq直连
 * 生产者生产消息到队列中，消费者然后去拿然后消费
 *
 * @author yishenheng
 * @date 4/22/21 8:35 PM
 */
@Configuration
public class DirectRabbitMqConfig {

    @Bean
    public Queue directQueue() {
        return new Queue("directQueue");
    }

    /**
     * 模拟队列超时未消费，死信队列消费
     *
     * @return
     */
    @Bean
    public Queue testTTLQueue() {
        Map<String, Object> args = new HashMap<>(4);
        args.put("x-message-ttl", 60000);
        args.put("x-dead-letter-routing-key", DeadLetterConstant.DEAD_LETTER_QUEUEA_ROUTING_KEY);
        args.put("x-dead-letter-exchange", DeadLetterConstant.DEAD_LETTER_EXCHANGE);
        return QueueBuilder.durable(RabbitMqConstant.TEST_TTL_QUEUE_NAME).withArguments(args).build();
    }
}
