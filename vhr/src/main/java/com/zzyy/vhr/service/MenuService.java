package com.zzyy.vhr.service;


import com.zzyy.vhr.mapper.MenuMapper;
import com.zzyy.vhr.mapper.Menu_roleMapper;
import com.zzyy.vhr.model.Hr;
import com.zzyy.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    Menu_roleMapper menu_roleMapper;

    public List<Menu> getMenusByHrId() {
        //获取当前登陆用户信息
        Hr hr =(Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return menuMapper.getMenusByHrId(hr.getId());
    }

    //@Cacheable
    public List<Menu> getAllMenusWithRole()
    {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    //事务操作
    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menu_roleMapper.deleteByRid(rid);
        Integer result =  menu_roleMapper.insertRecord(rid,mids);
        return result == mids.length;
    }
}
