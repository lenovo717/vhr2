package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper.VisitRecordMapper;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model.VisitRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitRecordService {

    @Autowired
    VisitRecordMapper visitRecordMapper;

    public List<VisitRecord> getRecordsByPatientId(String patient_id){
        return visitRecordMapper.getRecordsByPatientId(patient_id);
    }

    public RespPageBean getVistRecordByPage(Integer page, Integer size, String keyword) {
        if(page !=null && size !=null){
            page = (page-1) *size;
        }
        List<VisitRecord> data = visitRecordMapper.getVistRecordByPage(page,size,keyword);
        Long total = visitRecordMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public VisitRecord getRecordById(String record_id){
        return visitRecordMapper.getRecordById(record_id);
    }

    public int addRecord(VisitRecord record){
        return visitRecordMapper.insertVisitRecord(record);
    }

    public int updateRecord(VisitRecord record){
        return visitRecordMapper.updateByPrimaryKeySelective(record);
    }

    public int delRecord(String record_id){
        return visitRecordMapper.deleteByPrimaryKey(record_id);
    }

    public List<VisitRecord> getRecordsByCondition(VisitRecord record){
        String message = "where JSON_EXTRACT(hzzz, '$.\"活动能力\"')='卧床'";
//        String wheresql = "where hzzz->'$.\"焦虑/抑郁\"'='无焦虑和抑郁'";
//        select * from zzyy_hf_visit_record r where 1=1 and hzzz->'$."日常活动"' LIKE '%困难%'
//        select * from zzyy_hf_visit_record r where 1=1 and JSON_EXTRACT(hzzz,'$."日常活动"') LIKE '%困难%' ;
        return visitRecordMapper.getRecordsBySql(message);
    }

    public RespPageBean getVistRecordByBase(Integer page, Integer size, Integer base_id) {
        if(page !=null && size !=null){
            page = (page-1) *size;
        }
        List<VisitRecord> data = visitRecordMapper.getVistRecordByBase(page,size,base_id);
        Long total = visitRecordMapper.getTotalByBase(base_id);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }



}
