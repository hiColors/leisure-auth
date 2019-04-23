package com.github.life.lab.leisure.member.application.repository;

import com.github.life.lab.leisure.member.application.entity.EMemberDetail;
import com.github.lifelab.leisure.common.jpa.customiz.repository.ColorsRepository;
import org.springframework.stereotype.Repository;

/**
 * EMemberDetailRepository
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/2
 */
@Repository
public interface EMemberDetailRepository extends ColorsRepository<EMemberDetail, Long> {

}