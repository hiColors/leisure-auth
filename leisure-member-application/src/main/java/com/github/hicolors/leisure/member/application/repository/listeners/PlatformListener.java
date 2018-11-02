package com.github.hicolors.leisure.member.application.repository.listeners;

import com.github.hicolors.leisure.common.jpa.customiz.listener.AbstractListener;
import com.github.hicolors.leisure.member.application.repository.*;
import com.github.hicolors.leisure.member.model.persistence.*;
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

@Component
@Slf4j
public class PlatformListener extends AbstractListener implements PersistEventListener, MergeEventListener {

    @Autowired
    private PlatformOrganizationRepository organizationRepository;

    @Autowired
    private PlatformMemberRepository pmemberRepository;

    @Autowired
    private MemberRepository mmemberRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PlatformMemberRoleRepository pmrrepository;

    @Value("${platform.creator.default-role}")
    private Long creatorDefaultRoleId;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void onMerge(MergeEvent event) throws HibernateException {
        if (event.getResult() instanceof Platform) {
            Platform platform = (Platform) event.getResult();
            int result = organizationRepository.updateNameByPlatformAndLevelEquals0(platform.getName(), platform.getId());
            log.info("修改平台信息同步变更该平台 0 级组织架构信息 [id:{} ; name:{} ;result:{}]",platform.getId(),platform.getName(),result);
        }

    }

    @Override
    public void onMerge(MergeEvent event, Map copiedAlready) throws HibernateException {

    }

    @Override
    public void onPersist(PersistEvent event) throws HibernateException {
        if (event.getObject() instanceof Platform) {

            //自动创建 0 级组织
            Platform platform = (Platform) event.getObject();
            PlatformOrganization po = new PlatformOrganization();
            po.setPlatform(platform);
            po.setLevel(0);
            po.setParent(new PlatformOrganization(0L));
            po.setName(platform.getName());
            po.setComment("自动创建的全员群");
            organizationRepository.save(po);

            //创建第一个员工
            Member creator = mmemberRepository.getOne(platform.getOriginator());
            PlatformMember pm = new PlatformMember();
            pm.setPlatform(platform);
            pm.setPlatformOrganization(po);
            pm.setMember(creator);
            pm.setEntryDate(new Date());
            pm.setName(creator.getMemberDetail().getName());
            pmemberRepository.save(pm);

            //给创建人员工赋权限信息
            PlatformMemberRole platformMemberRole = new PlatformMemberRole();
            platformMemberRole.setPlatformMember(pm);
            platformMemberRole.setRole(roleRepository.findById(creatorDefaultRoleId).orElse(new Role()));
            pmrrepository.save(platformMemberRole);

        }
    }

    @Override
    public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
    }
}