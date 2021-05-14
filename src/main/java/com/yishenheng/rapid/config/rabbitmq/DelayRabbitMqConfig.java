package com.yishenheng.rapid.config.rabbitmq;

import com.yishenheng.rapid.constant.RabbitMqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yishenheng
 * @date 5/13/21 6:04 PM
 */
@Configuration
public class DelayRabbitMqConfig {


    /**
     * 定义一个延迟交换机
     *
     * @return
     */
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<String, Object>(2);
        args.put("x-delayed-type", "direct");
        return new CustomExchange(RabbitMqConstant.DELAY_EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }

    /**
     * 初始化延时队列
     *
     * @return
     */
    @Bean
    public Queue delayedQueue() {
        return new Queue(RabbitMqConstant.DELAYED_QUEUE_NAME);
    }

    /**
     * 绑定队列到这个延迟交换机上
     *
     * @return
     */
    @Bean
    public Binding bindingNotify() {
        return BindingBuilder.bind(delayedQueue()).to(delayExchange()).with(RabbitMqConstant.DELAYED_KEY_NAME).noargs();
    }

}
