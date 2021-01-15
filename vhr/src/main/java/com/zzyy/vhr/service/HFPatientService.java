package com.zzyy.vhr.service;


import com.zzyy.vhr.mapper.zzyy_hf_patientMapper;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model2.zzyy_hf_patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HFPatientService {

    @Autowired
    zzyy_hf_patientMapper patientMapper;

    public RespPageBean getPatientByPage(Integer page, Integer size, String keyword) {
        if(page !=null && size !=null){
            page = (page-1) *size;
        }
        Map<String, Object> qryData = new HashMap<String, Object>();
        qryData.put("pageIndex",page);
        qryData.put("size",size);
        qryData.put("keyword",keyword);
        List<zzyy_hf_patient> data = patientMapper.getPatientByPage(qryData);
        //Long total = employeeMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        //bean.setTotal(total);
        return bean;
    }


    public zzyy_hf_patient getPatientDetail(String patient_id)
    {
        return patientMapper.getPatientDetail(patient_id);
    }

    public int addHFPatient(zzyy_hf_patient patient) {
        patient.setSex("男");
        //获取最大的文件号
        zzyy_hf_patient p = patientMapper.getMaxFileId();

        if(p.getFileId() != null){

            int intNumber = Integer.parseInt(  p.getFileId().substring(1));
            intNumber++;
            String Number =  String.valueOf(intNumber);
            for (int i = 0; i < 3; i++){
                 Number = Number.length() < 3 ? "0" + Number : Number;
            }
             Number = "F" + Number;
            patient.setFileId(Number);
        }else{
            patient.setFileId("F001");
        }

        return patientMapper.insert(patient);
    }

    public zzyy_hf_patient getPatientBySocialNo(String social_no)
    {
        return patientMapper.getPatientBySocialNo(social_no);
    }

    public zzyy_hf_patient getPatientByFileId(String file_id)
    {
        return patientMapper.getPatientFileInfos(file_id);
    }

    public List<zzyy_hf_patient> getPatientsInProj(){
        return patientMapper.getPatientsInProj();
    }


}
