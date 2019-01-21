package com.github.life.lab.leisure.member.application.service.impl;

import com.github.life.lab.leisure.common.model.expression.ColorsExpression;
import com.github.life.lab.leisure.common.utils.ColorsBeanUtils;
import com.github.life.lab.leisure.member.application.entity.ERole;
import com.github.life.lab.leisure.member.application.repository.ERoleRepository;
import com.github.life.lab.leisure.member.application.service.RoleService;
import com.github.life.lab.leisure.member.model.exception.EnumLeisureMemberCodeMessage;
import com.github.life.lab.leisure.member.model.exception.LeisureMemberException;
import com.github.life.lab.leisure.member.model.resource.role.Role;
import com.github.life.lab.leisure.member.model.resource.role.RoleModel;
import com.github.life.lab.leisure.member.model.resource.role.RolePatchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private ERoleRepository repository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role create(RoleModel model) {
        if (repository.existsByCode(model.getCode())) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.ROLE_CODE_EXIST);
        }
        if (repository.existsByCode(model.getName())) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.ROLE_NAME_EXIST);
        }
        ERole eRole = new ERole();
        ColorsBeanUtils.copyPropertiesNonNull(model, eRole);
        //默认为启用
        eRole.setStatus(true);
        eRole = repository.save(eRole);
        return transferERole(eRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        repository.deleteByPrimaryKey(id);
    }

    @Override
    public Role modify(Long id, RolePatchModel model) {
        ERole eRole = getById(id);
        if (Objects.isNull(eRole)) {
            throw new LeisureMemberException(EnumLeisureMemberCodeMessage.ROLE_NON_EXIST);
        }
        ColorsBeanUtils.copyPropertiesNonNull(model, eRole);
        eRole = repository.saveAndFlush(eRole);
        return transferERole(eRole);
    }

    @Override
    public Role query(Long id) {
        return transferERole(getById(id));
    }

    @Override
    public Role queryByCode(String code) {
        ERole eRole = repository.findByCode(code);
        return transferERole(eRole);
    }

    @Override
    public Page<Role> paging(Pageable pageable, List<ColorsExpression> filters) {
        Page<ERole> eRolePage = repository.findPage(pageable,filters);
        List<Role> roles = new ArrayList<>();
        eRolePage.getContent().forEach(e->roles.add(transferERole(e)));
        Page<Role> result = new PageImpl(roles);
        ColorsBeanUtils.copyProperties(eRolePage,result,"content");
        return result;
    }


    private ERole getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    private Role transferERole(ERole eRole) {
        if (Objects.isNull(eRole)) {
            return null;
        }
        Role role = new Role();
        ColorsBeanUtils.copyPropertiesNonNull(eRole, role);
        return role;
    }

}
