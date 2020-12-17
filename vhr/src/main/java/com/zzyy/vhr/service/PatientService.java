package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper2.PatientMapper;
import com.zzyy.vhr.model.Employee;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model2.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientMapper patientMapper;

    public RespPageBean getHisPatientByPage(Integer page, Integer size, String keyword) {
        if(page !=null && size !=null){
            page = (page-1) *size;
        }
        List<Patient> data = patientMapper.getPatientByPage(page,size,keyword);
        //Long total = employeeMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        //bean.setTotal(total);
        return bean;
    }

    public RespPageBean getHisPatientDiagnosisByPage(Integer page, Integer size, String keyword) {
        if(page !=null && size !=null){
            page = (page-1) *size;
        }
        List<Patient> data = patientMapper.getPatientDiagnosisByPage(page,size,keyword);
        //Long total = employeeMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        //bean.setTotal(total);
        return bean;
    }

    public List<Patient> getHisPatientByProcedure(String dept_sn,String qry_date)
    {
        return patientMapper.getPatientByProcedure(dept_sn,qry_date);
    }

    public List<Patient> geHistPatientVisitDetailByProcedure(String patient_id,Integer times,Integer year)
    {
        return patientMapper.getPatientVisitDetailByProcedure(patient_id,times,year);
    }

    public Patient getPatientDetail(String patient_id)
    {
        return patientMapper.getPatientDetail(patient_id);
    }
}
