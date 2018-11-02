package com.github.hicolors.leisure.member.application.repository.listeners;

import com.github.hicolors.leisure.common.jpa.customiz.listener.AbstractListener;
import com.github.hicolors.leisure.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.MergeEvent;
import org.hibernate.event.spi.MergeEventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class PlatformListener extends AbstractListener implements MergeEventListener {

    @Override
    public void onMerge(MergeEvent event) throws HibernateException {
        log.info("onMerge {}", JsonUtils.serialize(event.getEntity()));
    }

    @Override
    public void onMerge(MergeEvent event, Map copiedAlready) throws HibernateException {
        log.info("onMerge {}", JsonUtils.serialize(event.getEntity()));
    }
}