package com.yishenheng.rapid.config.rabbitmq;

import com.yishenheng.rapid.constant.RabbitMqConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 路由模型
 *
 * @author yishenheng
 * @date 5/7/21 3:33 PM
 */
@Configuration
public class RoutingRabbitMqConfig {
    // 1.创建一个路由直连模型的交换机

    // 2.声明队列

    // 3.交换机和队列进行绑定。并指定路由KEY


    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMqConstant.ROUTING_DIRECT);
    }

    @Bean
    public Queue directQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue directQueue2() {
        return new AnonymousQueue();
    }


    @Bean
    public Binding binding() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(RabbitMqConstant.DIRECT_WITH_A);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with(RabbitMqConstant.DIRECT_WITH_B);
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with(RabbitMqConstant.DIRECT_WITH_C);
    }


}
