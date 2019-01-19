package com.github.life.lab.leisure.member.application.repository.listeners;

import com.github.life.lab.leisure.common.jpa.customiz.listener.AbstractListener;
import com.github.life.lab.leisure.member.application.entity.*;
import com.github.life.lab.leisure.member.application.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.MergeEvent;
import org.hibernate.event.spi.MergeEventListener;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * PlatformListener
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/11/3
 */
@Component
@Slf4j
public class EPlatformListener extends AbstractListener implements PersistEventListener, MergeEventListener {

    @Autowired
    private EPlatformOrganizationRepository organizationRepository;

    @Autowired
    private EPlatformMemberRepository pmemberRepository;

    @Autowired
    private EMemberRepository mmemberRepository;

    @Autowired
    private ERoleRepository roleRepository;

    @Autowired
    private EPlatformMemberRoleRepository pmrrepository;

    @Value("${platform.creator.default-role-name}")
    private String creatorDefaultRoleName;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void onMerge(MergeEvent event) throws HibernateException {
        if (event.getResult() instanceof EPlatform) {
            EPlatform platform = (EPlatform) event.getResult();
            int result = organizationRepository.updateNameByPlatformAndLevelEquals0(platform.getName(), platform.getId());
            log.info("修改平台信息同步变更该平台 0 级组织架构信息 [id:{} ; name:{} ;result:{}]", platform.getId(), platform.getName(), result);
        }

    }

    @Override
    public void onMerge(MergeEvent event, Map copiedAlready) throws HibernateException {

    }

    @Override
    public void onPersist(PersistEvent event) throws HibernateException {
        if (event.getObject() instanceof EPlatform) {

            //自动创建 0 级组织
            EPlatform platform = (EPlatform) event.getObject();
            EPlatformOrganization po = new EPlatformOrganization();
            po.setPlatform(platform);
            po.setLevel(0);
            po.setParent(new EPlatformOrganization(0L));
            po.setName(platform.getName());
            po.setComment("自动创建的全员群");
            organizationRepository.save(po);

            //创建第一个员工
            EMember creator = mmemberRepository.getOne(platform.getOriginator());
            EPlatformMember pm = new EPlatformMember();
            pm.setPlatform(platform);
            pm.setPlatformOrganization(po);
            pm.setMember(creator);
            pm.setEntryDate(new Date());
            pm.setName(creator.getMemberDetail().getName());
            pmemberRepository.save(pm);

            //给创建人员工赋权限信息
            EPlatformMemberRole platformMemberRole = new EPlatformMemberRole();
            platformMemberRole.setPlatformMember(pm);
            platformMemberRole.setRole(roleRepository.findByName(creatorDefaultRoleName));
            pmrrepository.save(platformMemberRole);

        }
    }

    @Override
    public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
    }
}