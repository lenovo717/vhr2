package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper.zzyy_hf_qyMapper;
import com.zzyy.vhr.model.zzyy_hf_qy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HFqyService {

    @Autowired
    zzyy_hf_qyMapper zzyy_hf_qyMapper;

    public zzyy_hf_qy getPatientFileDetail(int id)
    {
        return zzyy_hf_qyMapper.selectByPrimaryKey(id);
    }

    public List<zzyy_hf_qy> getList()
    {
        return zzyy_hf_qyMapper.getList();
    }

    public int updateHFPatientFileById(zzyy_hf_qy zzyy_hf_qy) {
        return zzyy_hf_qyMapper.updateByPrimaryKey(zzyy_hf_qy);
    }
}
