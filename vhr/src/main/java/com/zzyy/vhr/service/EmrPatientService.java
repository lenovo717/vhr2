package com.zzyy.vhr.service;


import com.zzyy.vhr.mapper3.EmrPatientMapper;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model3.EmrPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmrPatientService {

    @Autowired
    EmrPatientMapper patientMapper;

    public RespPageBean getEmrPatientByPage(Integer page, Integer size, String keyword) {
        if(page !=null && size !=null){
            page = (page-1) *size;
        }
        List<EmrPatient> data = patientMapper.getEmrPatientByPage(page,size,keyword);
        //Long total = employeeMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        //bean.setTotal(total);
        return bean;
    }

    public EmrPatient getPatientDetail(String patient_id,int time)
    {
        return patientMapper.getEmrPatientInfo(patient_id,time);
    }




}
