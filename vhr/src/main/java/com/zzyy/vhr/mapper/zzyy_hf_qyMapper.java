package com.zzyy.vhr.mapper;

import com.zzyy.vhr.model.zzyy_hf_qy;

import java.util.List;

public interface zzyy_hf_qyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(zzyy_hf_qy record);

    int insertSelective(zzyy_hf_qy record);

    zzyy_hf_qy selectByPrimaryKey(Integer id);

    List<zzyy_hf_qy> getList();

    int updateByPrimaryKeySelective(zzyy_hf_qy record);

    int updateByPrimaryKey(zzyy_hf_qy record);
}