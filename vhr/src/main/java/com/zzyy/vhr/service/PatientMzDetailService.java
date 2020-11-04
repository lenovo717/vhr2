package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper2.PatientMzDetailMapper;
import com.zzyy.vhr.model2.PatientMzDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientMzDetailService {
    @Autowired
    PatientMzDetailMapper patientMzDetailMapper;
    public List<PatientMzDetail> getPatientVisitDetailByProcedure(String patient_id, Integer times, Integer year)
    {
        return patientMzDetailMapper.getPatientVisitDetailByProcedure(patient_id,times,year);
    }
}
