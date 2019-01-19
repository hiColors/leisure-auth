package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.application.entity.EPlatformJob;
import org.springframework.stereotype.Repository;

/**
 * OrganizationRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface EPlatformJobRepository extends ColorsRepository<EPlatformJob, Long> {

    /**
     * 查找{ x}平台下{x}职称的岗位
     *
     * @param platformId 平台 id
     * @param title      职称
     * @return 平台岗位
     */
    EPlatformJob findByPlatformIdAndTitle(Long platformId, String title);
}