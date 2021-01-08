package com.zzyy.vhr.mapper;

import com.zzyy.vhr.model2.Patient;
import com.zzyy.vhr.model2.zzyy_hf_patient;
import com.zzyy.vhr.model2.zzyy_hf_patient_file_new;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface zzyy_hf_patient_file_newMapper {
    int insert(zzyy_hf_patient_file_new record);

    int insertSelective(zzyy_hf_patient_file_new record);

    int deletePatientFile(@Param("file_id") String file_id,@Param("class_name") String class_name);

    List<zzyy_hf_patient_file_new>  getPatientFileInfos(String file_id);
    List<zzyy_hf_patient>  getPatientFileByQry(String condition);
}