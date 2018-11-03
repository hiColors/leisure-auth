package com.github.hicolors.leisure.member.application.repository;

import com.github.hicolors.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.hicolors.leisure.member.model.persistence.PlatformOrganization;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * OrganizationRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/10/2
 */
@Repository
public interface PlatformOrganizationRepository extends ColorsRepository<PlatformOrganization, Long> {

    @Query("from PlatformOrganization where platform.id = :platformId and level = 0")
    PlatformOrganization findByPlatformAndLevelEquals0(@Param("platformId") Long platformId);

    @Query("update PlatformOrganization set name = :name where platform.id = :platformId and level = 0")
    @Modifying
    Integer updateNameByPlatformAndLevelEquals0(@Param("name") String name, @Param("platformId") Long platformId);

    PlatformOrganization findByPlatformIdAndName(Long pid, String name);
}