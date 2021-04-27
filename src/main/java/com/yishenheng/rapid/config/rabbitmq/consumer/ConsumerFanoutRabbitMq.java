package com.yishenheng.rapid.config.rabbitmq.consumer;

import cn.hutool.json.JSONUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 广播（发布订阅）的消费
 * 应用的场景就是 一个内容，多个实现。
 *
 * @author yishenheng
 * @date 4/27/21 9:59 PM
 */
@Component
public class ConsumerFanoutRabbitMq {


    @RabbitListener(queues = "yshTest")
    public void print(Map<String, Object> map) {
        // 单纯的输出
        System.out.println(JSONUtil.toJsonStr(map));
    }

    @RabbitListener(queues = "yshTest1")
    public void addPointsPrint(Map<String, Object> map) {
        // count添加后输出
        map.put("count", Integer.parseInt(map.get("count").toString()) + 1);
        System.out.println(JSONUtil.toJsonStr(map));
    }

    @RabbitListener(queues = "yshTest2")
    public void addContentPrint(Map<String, Object> map) {
        map.put("content", "西湖美景三月天呐~");
        System.out.println(JSONUtil.toJsonStr(map));
    }
}
