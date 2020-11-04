package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper.JoblevelMapper;
import com.zzyy.vhr.model.Joblevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {
    @Autowired
    JoblevelMapper joblevelMapper;
    public List<Joblevel> getAllJobLevels() {
       return  joblevelMapper.getAllJobLevels();
    }

    public int addJoblevel(Joblevel joblevel) {
        joblevel.setCreateDate(new Date( ));
        joblevel.setEnabled(true);
        return joblevelMapper.insertSelective(joblevel);
    }

    public int updateJoblevelById(Joblevel joblevel) {
        return joblevelMapper.updateByPrimaryKeySelective(joblevel);
    }

    public int deleteJoblevelById(Integer id) {
        return joblevelMapper.deleteByPrimaryKey(id);
    }
}
