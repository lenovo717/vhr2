package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper2.HFPatientMapper;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model2.HFPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HFPatientService {

    @Autowired
    HFPatientMapper patientMapper;

    public RespPageBean getPatientByPage(Integer page, Integer size, String keyword) {
        if(page !=null && size !=null){
            page = (page-1) *size;
        }
        List<HFPatient> data = patientMapper.getPatientByPage(page,size,keyword);
        //Long total = employeeMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        //bean.setTotal(total);
        return bean;
    }


    public HFPatient getPatientDetail(String patient_id)
    {
        return patientMapper.getPatientDetail(patient_id);
    }
}
