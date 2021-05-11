package com.yishenheng.rapid.config.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yishenheng
 * @date 5/10/21 9:35 AM
 */
@Component
@Slf4j
public class ConsumerTopicRabbitMq {


    /**
     * 消费topic.* 的内容
     *
     * @param content 内容
     */
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(),
                    key = {"topic.*", "topic.*.*"},
                    exchange = @Exchange(type = "topic", name = "topics")
            )
    )
    public void topicsSingleWordPrint(String content) {
        log.info("singleWord=========>{}", content);
    }

    /**
     * 消费topic.# 的内容
     *
     * @param content 内容
     */
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(),
                    key = {"topic.#"},
                    exchange = @Exchange(type = "topic", name = "topics")
            )
    )
    public void topicsArbitraryWordPrint(String content) {
        log.info("arbitraryWord=========>{}", content);
    }
}
