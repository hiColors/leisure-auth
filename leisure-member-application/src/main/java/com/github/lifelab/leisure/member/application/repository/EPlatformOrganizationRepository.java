package com.github.lifelab.leisure.member.application.repository;

import com.github.lifelab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.lifelab.leisure.member.application.entity.EPlatformOrganization;
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

    /**
     * 查询平台顶级组织
     *
     * @param platformId 平台 id
     * @return 组织架构信息
     */
    @Query("from EPlatformOrganization where platform.id = :platformId and level = 0")
    EPlatformOrganization findByPlatformAndLevelEquals0(@Param("platformId") Long platformId);

    /**
     * 更新顶级组织名称
     *
     * @param name       新名称
     * @param platformId 平台 id
     * @return 影响行数
     */
    @Query("update EPlatformOrganization set name = :name where platform.id = :platformId and level = 0")
    @Modifying
    Integer updateNameByPlatformAndLevelEquals0(@Param("name") String name, @Param("platformId") Long platformId);

    /**
     * 通过平台 id 和 组织架构名称查询组织
     *
     * @param pid  平台 id
     * @param name 组织架构名称
     * @return 组织架构信息
     */
    EPlatformOrganization findByPlatformIdAndName(Long pid, String name);

    /**
     * 根据 id 和 平台 id 判断是否存在
     *
     * @param id  id
     * @param pid 平台 id
     * @return if exist true,else false
     */
    boolean existsByIdAndPlatformId(Long id, Long pid);
}