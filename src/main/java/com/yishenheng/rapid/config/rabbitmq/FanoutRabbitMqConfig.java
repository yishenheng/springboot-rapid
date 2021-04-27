package com.yishenheng.rapid.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 发布订阅的消息类型
 *
 * @author yishenheng
 * @date 4/27/21 9:28 PM
 */
@Configuration
public class FanoutRabbitMqConfig {

    // 1.首先先创建一个交换机
    // 2.创建三个队列
    // 3.交换机和队列绑定


    private static final String FANOUT_NAME = "fanoutYsh";

    private static final String QUEUE_NAME = "yshTest";

    private static final String QUEUE_NAME1 = "yshTest1";

    private static final String QUEUE_NAME2 = "yshTest2";
    
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_NAME);
    }

    @Bean
    public Queue createTestQueue() {
        return new Queue(QUEUE_NAME, true, false, true);
    }

    @Bean
    public Queue createTestQueue1() {
        return new Queue(QUEUE_NAME1, true, false, true);
    }

    @Bean
    public Queue createTestQueue2() {
        return new Queue(QUEUE_NAME2, true, false, true);
    }

    @Bean
    public Binding fanoutTiedUpQueue() {
        return BindingBuilder.bind(createTestQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutTiedUpQueue1() {
        return BindingBuilder.bind(createTestQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutTiedUpQueue2() {
        return BindingBuilder.bind(createTestQueue2()).to(fanoutExchange());
    }
}
