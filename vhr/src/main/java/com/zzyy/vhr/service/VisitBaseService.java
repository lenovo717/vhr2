package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper2.VisitBaseMapper;
import com.zzyy.vhr.mapper2.VisitRecordMapper;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model2.VisitBase;
import com.zzyy.vhr.model2.VisitRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitBaseService {

    @Autowired
    VisitBaseMapper visitBaseMapper;

    public RespPageBean getVisitBaseByPage(Integer page, Integer size, String keyword) {
        if(page !=null && size !=null){
            page = (page-1) *size;
        }
        List<VisitBase> data = visitBaseMapper.getVisitBaseByPage(page,size,keyword);
        Long total = visitBaseMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public VisitBase getBaseById(String record_id){
        return visitBaseMapper.getVisitBaseById(record_id);
    }

    public int addBase(VisitBase record){
        return visitBaseMapper.insertVisitBase(record);
    }

    public int updateBase(VisitBase record){
        return visitBaseMapper.updateByPrimaryKeySelective(record);
    }

    public int delBase(String record_id){
        return visitBaseMapper.deleteByPrimaryKey(record_id);
    }

}
