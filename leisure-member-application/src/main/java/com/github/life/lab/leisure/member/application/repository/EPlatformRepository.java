package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.common.jpa.customiz.repository.ColorsRepository;
import com.github.life.lab.leisure.member.application.entity.EPlatform;
import org.springframework.stereotype.Repository;

/**
 * GroupRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface EPlatformRepository extends ColorsRepository<EPlatform, Long> {

    EPlatform findByName(String name);

}