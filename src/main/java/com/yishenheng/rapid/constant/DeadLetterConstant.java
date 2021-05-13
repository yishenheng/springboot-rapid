package com.yishenheng.rapid.constant;

/**
 * @author yishenheng
 * @date 5/12/21 5:37 PM
 */
public interface DeadLetterConstant {
    String BUSINESS_EXCHANGE_NAME = "dead.letter.demo.simple.business.exchange";
    String BUSINESS_QUEUEA_NAME = "dead.letter.demo.simple.business.queuea";
    String BUSINESS_QUEUEB_NAME = "dead.letter.demo.simple.business.queueb";
    String DEAD_LETTER_EXCHANGE = "dead.letter.demo.simple.deadletter.exchange";
    String DEAD_LETTER_QUEUEA_ROUTING_KEY = "dead.letter.demo.simple.deadletter.queuea.routingkey";
    String DEAD_LETTER_QUEUEB_ROUTING_KEY = "dead.letter.demo.simple.deadletter.queueb.routingkey";
    String DEAD_LETTER_QUEUEA_NAME = "dead.letter.demo.simple.deadletter.queuea";
    String DEAD_LETTER_QUEUEB_NAME = "dead.letter.demo.simple.deadletter.queueb";
}
