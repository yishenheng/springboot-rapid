package com.yishenheng.rapid.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
