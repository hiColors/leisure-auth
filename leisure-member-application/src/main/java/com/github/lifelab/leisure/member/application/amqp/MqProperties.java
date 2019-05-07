package com.github.lifelab.leisure.member.application.amqp;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * MqProperties
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/17
 */
@Component
@Getter
public class MqProperties {

    @Value("${rabbit.queue.leisure-member.member:rabbit_queue_leisure_member_member}")
    private String memberQueue;

    @Value("${rabbit.exchange.topic.leisure-member.member:rabbit_exchange_topic_leisure_member_member}")
    private String memberTopicExchange;

    @Value("${rabbit.routing-key.leisure-member.member:rabbit_routing_key_leisure_member_member}")
    private String memberRoutingKey;
}
