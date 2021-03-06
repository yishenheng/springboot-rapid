package com.yishenheng.rapid.controller;

import cn.hutool.core.date.DateUtil;
import com.yishenheng.rapid.constant.DeadLetterConstant;
import com.yishenheng.rapid.constant.RabbitMqConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yishenheng
 * @date 4/27/21 10:35 PM
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {


    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProducerController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    /**
     * 单发和work
     */
    @PostMapping("/work")
    public void addWorkMessage() {
        for (int i = 0; i < 10; i++) {
            this.rabbitTemplate.convertAndSend(RabbitMqConstant.DIRECT_QUEUE, i + "");
        }


        this.rabbitTemplate.convertAndSend(RabbitMqConstant.TEST_TTL_QUEUE_NAME, "test");
    }

    /**
     * 广播（订阅发布）
     */
    @PostMapping("/fanout")
    public void addFanoutMessage() {
        Map<String, Object> map = new HashMap<>(4);
        map.put("date", DateUtil.now());
        map.put("msg", "hello 广播的消息类型");
        map.put("count", 10);
        this.rabbitTemplate.convertAndSend(RabbitMqConstant.FANOUT_EXCHANGE_NAME, "", map);
    }


    /**
     * 路由
     */
    @PostMapping("/routing")
    public void addRoutingMessage() {
        String info = "hello routing date:" + DateUtil.now();
        this.rabbitTemplate.convertAndSend(RabbitMqConstant.ROUTING_DIRECT, RabbitMqConstant.DIRECT_WITH_B, info);
        this.rabbitTemplate.convertAndSend(RabbitMqConstant.ROUTING_DIRECT, RabbitMqConstant.DIRECT_WITH_A, info);
        this.rabbitTemplate.convertAndSend(RabbitMqConstant.ROUTING_DIRECT, RabbitMqConstant.DIRECT_WITH_C, info);
    }

    /**
     * 路由
     */
    @PostMapping("/topics")
    public void addTopicMessage() {
        String info = "hello topic date:" + DateUtil.now();
        this.rabbitTemplate.convertAndSend(RabbitMqConstant.TOPIC_NAME, "topic.a.x.((((((.asdas", info);
    }

    @PostMapping("/deadLetter")
    public void addDeadLetterMessage() {
        String info = "test" + DateUtil.now();
        this.rabbitTemplate.convertAndSend(DeadLetterConstant.BUSINESS_EXCHANGE_NAME, "", info);
    }

    @PostMapping("/delayed")
    public void delayedMessage() throws InterruptedException {
        System.out.println("发送消息的时间:{}" + DateUtil.now());
        String context = "test delay message date:" + DateUtil.now();
        rabbitTemplate.convertAndSend(RabbitMqConstant.DELAY_EXCHANGE_NAME, RabbitMqConstant.DELAYED_KEY_NAME, context, info -> {
            info.getMessageProperties().setDelay(6000);
            return info;
        });

    }

}
