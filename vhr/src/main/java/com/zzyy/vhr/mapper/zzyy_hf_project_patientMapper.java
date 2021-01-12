package com.zzyy.vhr.mapper;

import com.zzyy.vhr.model2.zzyy_hf_project_patient;
import org.apache.ibatis.annotations.Param;

public interface zzyy_hf_project_patientMapper {
    int insert(zzyy_hf_project_patient record);

    int insertSelective(zzyy_hf_project_patient record);

    zzyy_hf_project_patient getPatientByFileId(@Param("file_id") String file_id);
}