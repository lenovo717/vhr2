package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper.RoleMapper;
import com.zzyy.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addMenuRole(Role role) {
        if(!role.getName().startsWith("ROLE_"))
            role.setName("ROLE_"+role.getName());
       return roleMapper.insertSelective(role);

    }

    public int deleteMenuRole(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
