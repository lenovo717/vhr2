package com.zzyy.vhr.mapper;

import com.zzyy.vhr.model2.zzyy_hf_patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface zzyy_hf_patientMapper {
    int insert(zzyy_hf_patient record);

    int insertSelective(zzyy_hf_patient record);

    //List<zzyy_hf_patient> getPatientByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyword") String keyword);
    List<zzyy_hf_patient> getPatientByPage(Map<String,Object> qryData);
    zzyy_hf_patient getPatientDetail(@Param("patient_id") String patient_id);


    zzyy_hf_patient getPatientFileInfos(@Param("file_id") String file_id);
    zzyy_hf_patient getPatientBySocialNo(@Param("social_no") String social_no);

    zzyy_hf_patient getMaxFileId();

    List<zzyy_hf_patient> getPatientsInProj();

}