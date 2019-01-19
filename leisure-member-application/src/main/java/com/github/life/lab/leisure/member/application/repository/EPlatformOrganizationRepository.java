package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.application.entity.EPlatformOrganization;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * OrganizationRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface EPlatformOrganizationRepository extends ColorsRepository<EPlatformOrganization, Long> {

    @Query("from EPlatformOrganization where platform.id = :platformId and level = 0")
    EPlatformOrganization findByPlatformAndLevelEquals0(@Param("platformId") Long platformId);

    @Query("update EPlatformOrganization set name = :name where platform.id = :platformId and level = 0")
    @Modifying
    Integer updateNameByPlatformAndLevelEquals0(@Param("name") String name, @Param("platformId") Long platformId);

    EPlatformOrganization findByPlatformIdAndName(Long pid, String name);
}