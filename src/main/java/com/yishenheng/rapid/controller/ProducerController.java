package com.yishenheng.rapid.controller;

import cn.hutool.core.date.DateUtil;
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


    @PostMapping("/routing")
    public void addRoutingMessage() {
        String info = "hello routing";
        this.rabbitTemplate.convertAndSend(RabbitMqConstant.ROUTING_DIRECT, RabbitMqConstant.DIRECT_WITH_B, info);
    }
}
