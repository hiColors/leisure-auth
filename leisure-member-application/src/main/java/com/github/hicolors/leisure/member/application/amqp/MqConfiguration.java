package com.github.hicolors.leisure.member.application.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AmqpConfiguration
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/17
 */
@Configuration
public class MqConfiguration {

    @Autowired
    private MqProperties mqProperties;

    @Bean
    public Queue memberQueue() {
        return new Queue(mqProperties.getMemberQueue());
    }

    @Bean
    public TopicExchange memberTopicExchange() {
        return new TopicExchange(mqProperties.getMemberTopicExchange());
    }

    @Bean
    public Binding memberBinding() {
        return BindingBuilder.bind(memberQueue()).to(memberTopicExchange()).with(mqProperties.getMemberRoutingKey());
    }
}