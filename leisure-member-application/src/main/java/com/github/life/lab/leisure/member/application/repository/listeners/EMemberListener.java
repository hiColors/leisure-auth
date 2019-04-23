package com.github.life.lab.leisure.member.application.repository.listeners;

import com.github.life.lab.leisure.member.application.amqp.MqProperties;
import com.github.life.lab.leisure.member.application.entity.EMember;
import com.github.lifelab.leisure.common.jpa.customiz.listener.AbstractListener;
import com.github.lifelab.leisure.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.MergeEvent;
import org.hibernate.event.spi.MergeEventListener;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * PlatformListener
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/3
 */
@Component
@Slf4j
public class EMemberListener extends AbstractListener implements PersistEventListener, MergeEventListener {

    @Autowired
    private MqProperties mqProperties;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    @Async
    public void onMerge(MergeEvent event) throws HibernateException {
        if (event.getResult() instanceof EMember) {
            log.info("member 信息变更，发送 rabbit mq，member: [{}]", ((EMember) event.getResult()).getId());
            rabbitTemplate.convertAndSend(mqProperties.getMemberTopicExchange(), mqProperties.getMemberRoutingKey(), ((EMember) event.getResult()).getId());
        }

    }

    @Override
    public void onMerge(MergeEvent event, Map copiedAlready) throws HibernateException {

    }

    @Override
    @Async
    public void onPersist(PersistEvent event) throws HibernateException {
        if (event.getObject() instanceof EMember) {
            EMember eMember = (EMember) event.getObject();
            log.info(JsonUtils.serialize(eMember));
        }
    }

    @Override
    public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
    }
}