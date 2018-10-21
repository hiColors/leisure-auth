package com.github.hicolors.leisure.member.application.service.impl;

import com.github.hicolors.leisure.common.exception.ResourceNotFoundException;
import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.application.exception.EnumCodeMessage;
import com.github.hicolors.leisure.member.application.exception.MemberServerException;
import com.github.hicolors.leisure.member.application.repository.RoleRepository;
import com.github.hicolors.leisure.member.application.service.RoleService;
import com.github.hicolors.leisure.member.model.model.role.RoleModel;
import com.github.hicolors.leisure.member.model.persistence.Role;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role create(RoleModel model) {
        checkName(model.getName(),null);
        Role role = new Role();
        BeanUtils.copyProperties(model,role);
        return repository.save(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role modify(Role role, RoleModel model) {
        checkName(model.getName(),role.getId());
        BeanUtils.copyProperties(model,role);
        return repository.saveAndFlush(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role modifyAll(Role role, RoleModel model) {
        checkName(model.getName(),role.getId());
        BeanUtils.copyProperties(model,role);
        return repository.saveAndFlush(role);
    }

    @Override
    public Role queryOne(Long id) {
        Optional<Role> role = repository.findById(id);
        if(role.isPresent()){
            return role.get();
        }else{
            throw new ResourceNotFoundException(MessageFormat.format("该 id[{0}] 对应的角色不存在！",id));
        }
    }

    @Override
    public Page<Role> queryPage(Pageable pageable, List<ColorsExpression> filters) {
        return repository.findPage(pageable,filters);
    }

    private void checkName(String name,Long id){
        Role role = repository.findByName(name);
        if(Objects.nonNull(role)){
            id = ObjectUtils.defaultIfNull(id,0L);
            if(!id.equals(role.getId())){
                throw new MemberServerException(EnumCodeMessage.ROLE_NAME_EXIST);
            }
        }
    }
}
