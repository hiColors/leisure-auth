package com.github.lifelab.leisure.member.application.service.impl;

import com.github.lifelab.leisure.common.model.expression.ColorsExpression;
import com.github.lifelab.leisure.common.utils.ColorsBeanUtils;
import com.github.lifelab.leisure.member.application.entity.ERole;
import com.github.lifelab.leisure.member.application.repository.EMemberRoleRepository;
import com.github.lifelab.leisure.member.application.repository.EPlatformMemberRoleRepository;
import com.github.lifelab.leisure.member.application.repository.ERoleRepository;
import com.github.lifelab.leisure.member.application.service.RoleService;
import com.github.lifelab.leisure.member.application.transfer.EntityTransferUtils;
import com.github.lifelab.leisure.member.model.exception.EnumExceptionMessageLeisureMember;
import com.github.lifelab.leisure.member.model.exception.LeisureMemberException;
import com.github.lifelab.leisure.member.model.resource.role.Role;
import com.github.lifelab.leisure.member.model.resource.role.RoleModel;
import com.github.lifelab.leisure.member.model.resource.role.RolePatchModel;
import com.github.lifelab.leisure.member.model.resource.role.RoleStatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * RoleServiceImpl
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-01-20
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final ERoleRepository repository;

    private final EMemberRoleRepository memberRoleRepository;

    private final EPlatformMemberRoleRepository platformMemberRoleRepository;

    @Autowired
    public RoleServiceImpl(ERoleRepository repository, EMemberRoleRepository memberRoleRepository,
                           EPlatformMemberRoleRepository platformMemberRoleRepository) {
        this.repository = repository;
        this.memberRoleRepository = memberRoleRepository;
        this.platformMemberRoleRepository = platformMemberRoleRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role create(RoleModel model) {
        if (repository.existsByCode(model.getCode())) {
            throw new LeisureMemberException(EnumExceptionMessageLeisureMember.ROLE_CODE_EXIST);
        }
        if (repository.existsByCode(model.getName())) {
            throw new LeisureMemberException(EnumExceptionMessageLeisureMember.ROLE_NAME_EXIST);
        }
        ERole eRole = new ERole();
        ColorsBeanUtils.copyPropertiesNonNull(model, eRole);
        //默认为启用
        eRole.setStatus(true);
        eRole = repository.save(eRole);
        return EntityTransferUtils.transferERole(eRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        //判断是否已经有人员、员工赋值了该角色
        if (memberRoleRepository.existsByRoleId(id) || platformMemberRoleRepository.existsByRoleId(id)) {
            throw new LeisureMemberException(EnumExceptionMessageLeisureMember.ROLE_USED_DENY_DELETE);
        }
        repository.deleteByPrimaryKey(id);
    }

    @Override
    public Role modify(Long id, RolePatchModel model) {
        ERole eRole = getById(id);
        if (Objects.isNull(eRole)) {
            throw new LeisureMemberException(EnumExceptionMessageLeisureMember.ROLE_NON_EXIST);
        }
        ColorsBeanUtils.copyPropertiesNonNull(model, eRole);
        eRole = repository.saveAndFlush(eRole);
        return EntityTransferUtils.transferERole(eRole);
    }

    @Override
    public Role modifyStatus(Long id, RoleStatusModel model) {
        ERole eRole = getById(id);
        if (Objects.isNull(eRole)) {
            throw new LeisureMemberException(EnumExceptionMessageLeisureMember.ROLE_NON_EXIST);
        }
        eRole.setStatus(model.getStatus());
        eRole = repository.saveAndFlush(eRole);
        return EntityTransferUtils.transferERole(eRole);
    }

    @Override
    public Role query(Long id) {
        return EntityTransferUtils.transferERole(getById(id));
    }

    @Override
    public Role queryByKey(String key, String keyType) {
        switch (keyType.toLowerCase()) {
            case "id":
                return query(Long.valueOf(key));
            case "code":
                return queryByCode(key);
            default:
                throw new LeisureMemberException(EnumExceptionMessageLeisureMember.ROLE_QUERY_NON_SUPPORT);

        }
    }

    @Override
    public Role queryByCode(String code) {
        return EntityTransferUtils.transferERole(repository.findByCode(code));
    }

    @Override
    public Page<Role> paging(Pageable pageable, List<ColorsExpression> filters) {
        return repository.findPage(pageable, filters).map(EntityTransferUtils::transferERole);
    }

    private ERole getById(Long id) {
        return repository.findById(id).orElse(null);
    }

}