package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper.zzyy_hf_patient_file_newMapper;
import com.zzyy.vhr.mapper.zzyy_hf_project_patientMapper;
import com.zzyy.vhr.mapper2.HFPatientFileMapper;
import com.zzyy.vhr.model2.HFPatientFile;
import com.zzyy.vhr.model2.zzyy_hf_patient;
import com.zzyy.vhr.model2.zzyy_hf_patient_file_new;
import com.zzyy.vhr.model2.zzyy_hf_project_patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HFProjectPatService {

    @Autowired
    zzyy_hf_project_patientMapper hf_project_patientMapper;


    public int addProjectPat(zzyy_hf_project_patient patient) {
      return  hf_project_patientMapper.insert(patient);
    }

    public zzyy_hf_project_patient getPatientByFileId(String file_id)
    {
        return hf_project_patientMapper.getPatientByFileId(file_id);
    }







}
