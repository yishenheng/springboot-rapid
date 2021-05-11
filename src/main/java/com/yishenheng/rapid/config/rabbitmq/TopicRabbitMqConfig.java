//package com.yishenheng.rapid.config.rabbitmq;
//
//import com.yishenheng.rapid.constant.RabbitMqConstant;
//import org.springframework.amqp.core.AnonymousQueue;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 动态路由
// *
// * @author yishenheng
// * @date 5/10/21 9:12 AM
// */
//@Configuration
//public class TopicRabbitMqConfig {
//    //1、声明交换机
//    //2、声明队列
//    //3、绑定队列和交换机并且给出匹配规则
//
//    @Bean
//    public TopicExchange topicExchange() {
//        return new TopicExchange(RabbitMqConstant.TOPIC_NAME);
//    }
//
//    @Bean
//    public AnonymousQueue topicQueue() {
//        return new AnonymousQueue();
//    }
//
//    @Bean
//    public AnonymousQueue topicQueue1() {
//        return new AnonymousQueue();
//    }
//
//    @Bean
//    public AnonymousQueue topicQueue2() {
//        return new AnonymousQueue();
//    }
//
//    @Bean
//    public Binding topicBinding() {
//        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(RabbitMqConstant.TOPIC_WITH_SINGLE);
//    }
//
//    @Bean
//    public Binding topicBinding1() {
//        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(RabbitMqConstant.TOPIC_WITH_TWO);
//    }
//
//    @Bean
//    public Binding topicBinding2() {
//        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(RabbitMqConstant.TOPIC_WITH_ARBITRARY);
//    }
//}
