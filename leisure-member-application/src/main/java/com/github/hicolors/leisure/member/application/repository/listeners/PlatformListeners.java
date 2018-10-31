package com.github.hicolors.leisure.member.application.repository.listeners;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.*;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PlatformListeners implements PostCommitUpdateEventListener, PostCommitInsertEventListener, PostCommitDeleteEventListener {


    @Override
    public void onPostUpdateCommitFailed(PostUpdateEvent event) {
        log.info("PlatformListeners");
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        log.info("PlatformListeners");
    }


    @Override
    public void onPostInsertCommitFailed(PostInsertEvent event) {
        log.info("PlatformListeners");
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        log.info("PlatformListeners");
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return false;
    }

    @Override
    public void onPostDeleteCommitFailed(PostDeleteEvent event) {
        log.info("PlatformListeners");
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        log.info("PlatformListeners");
    }
}
