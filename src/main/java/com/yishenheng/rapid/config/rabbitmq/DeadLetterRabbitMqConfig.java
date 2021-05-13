package com.yishenheng.rapid.config.rabbitmq;

import com.yishenheng.rapid.constant.DeadLetterConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 死信队列
 *
 * @author yishenheng
 * @date 5/12/21 11:03 AM
 */
@Configuration
public class DeadLetterRabbitMqConfig {


    /**
     * 业务交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange businessExchange() {
        return new FanoutExchange(DeadLetterConstant.BUSINESS_EXCHANGE_NAME);
    }


    /**
     * 业务队列1
     *
     * @return
     */
    @Bean
    public Queue businessQueueA() {
        Map<String, Object> args = new HashMap<>(2);
        // 这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", DeadLetterConstant.DEAD_LETTER_EXCHANGE);
        // 这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", DeadLetterConstant.DEAD_LETTER_QUEUEA_ROUTING_KEY);
        return QueueBuilder.durable(DeadLetterConstant.BUSINESS_QUEUEA_NAME).withArguments(args).build();
    }

    /**
     * 业务队列2
     *
     * @return
     */
    @Bean
    public Queue businessQueueB() {
        Map<String, Object> args = new HashMap<>(2);
        args.put("x-dead-letter-routing-key", DeadLetterConstant.DEAD_LETTER_QUEUEB_ROUTING_KEY);
        args.put("x-dead-letter-exchange", DeadLetterConstant.DEAD_LETTER_EXCHANGE);
        return QueueBuilder.durable(DeadLetterConstant.BUSINESS_QUEUEB_NAME).withArguments(args).build();
    }


    @Bean
    public Binding businessBindingA() {
        return BindingBuilder.bind(businessQueueA()).to(businessExchange());
    }

    @Bean
    public Binding businessBindingB() {
        return BindingBuilder.bind(businessQueueB()).to(businessExchange());
    }


    /**
     * 声明死信队列
     *
     * @return
     */
    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(DeadLetterConstant.DEAD_LETTER_EXCHANGE);
    }

    /**
     * 声明死信队列A
     *
     * @return
     */
    @Bean
    public Queue deadLetterQueueA() {
        return new Queue(DeadLetterConstant.DEAD_LETTER_QUEUEA_NAME);
    }



    /**
     * 死信队列绑定队列A（非声明死信队列的A）
     *
     * @return
     */
    @Bean
    public Binding deadLetterBindingA() {
        return BindingBuilder.bind(deadLetterQueueA()).to(deadLetterExchange()).with(DeadLetterConstant.DEAD_LETTER_QUEUEA_ROUTING_KEY);
    }
}
