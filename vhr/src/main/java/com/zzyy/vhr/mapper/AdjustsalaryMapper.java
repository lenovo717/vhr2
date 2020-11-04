package com.zzyy.vhr.mapper;

import com.zzyy.vhr.model.Adjustsalary;

public interface AdjustsalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Adjustsalary record);

    int insertSelective(Adjustsalary record);

    Adjustsalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Adjustsalary record);

    int updateByPrimaryKey(Adjustsalary record);
}