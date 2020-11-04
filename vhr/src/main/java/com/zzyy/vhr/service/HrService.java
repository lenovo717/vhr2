package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper.HrMapper;
import com.zzyy.vhr.mapper.Hr_roleMapper;
import com.zzyy.vhr.model.Hr;
import com.zzyy.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Autowired
    Hr_roleMapper hr_roleMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(s);
        if(hr==null)
            throw new UsernameNotFoundException("用户名不存在");
        //登陆成功
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
       //List<Hr> list =  hrMapper.getAllHrs(HrUtils.getCurrentHr().getId());
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    public int updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
       hr_roleMapper.deleteByHrid(hrid);
       return hr_roleMapper.addRole(hrid,rids)==rids.length;
    }

    public int deleteHrById(Integer id) {
       return  hrMapper.deleteByPrimaryKey(id);
    }
}
