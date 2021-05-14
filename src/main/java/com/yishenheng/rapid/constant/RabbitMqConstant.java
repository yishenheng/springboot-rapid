package com.yishenheng.rapid.constant;

/**
 * @author yishenheng
 * @date 4/29/21 6:00 PM
 */
public interface RabbitMqConstant {

    String DIRECT_QUEUE = "directQueue";
    String TEST_TTL_QUEUE_NAME = "ttlQueue";

    String FANOUT_QUEUE = "yshTest";

    String FANOUT_QUEUE1 = "yshTest1";

    String FANOUT_QUEUE2 = "yshTest2";

    String FANOUT_EXCHANGE_NAME = "fanoutYsh";


    String ROUTING_DIRECT = "routingDirect";


    String TOPIC_NAME = "topics";

    String TOPIC_WITH_SINGLE = "topics.*";

    String TOPIC_WITH_TWO= "topics.*.*";

    String TOPIC_WITH_ARBITRARY = "topics.#";


    String DIRECT_WITH_A = "a";

    String DIRECT_WITH_B = "b";

    String DIRECT_WITH_C = "c";


    String  DELAY_EXCHANGE_NAME = "delayExchange";

    String  DELAYED_KEY_NAME = "delayedKey";

    String  DELAYED_QUEUE_NAME = "delayQueue";
}
