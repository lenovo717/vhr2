package com.zzyy.vhr.service;

import com.zzyy.vhr.dto.VisitBaseDTO;
import com.zzyy.vhr.mapper.VisitBaseMapper;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model.VisitBase;
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

    public RespPageBean getVisitBasesByPage(Integer page, Integer size,
                                            String doctor_sn, String project_id, String patient_id) {
        if(page !=null && size !=null){
            page = (page-1) *size;
        }
        List<VisitBaseDTO> data = visitBaseMapper.getVisitBasesByPage(page,size,doctor_sn,project_id, patient_id);
        Long total = visitBaseMapper.getTotals(doctor_sn,project_id, patient_id);
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

    public boolean validateBaseAndDoc(String doctor_sn, Integer base_id){
        List<Integer> baseList = visitBaseMapper.getBaseByDoc(doctor_sn);
        if(baseList.contains(base_id.toString())){
            return true;
        }else {
            return false;
        }
    }
}
