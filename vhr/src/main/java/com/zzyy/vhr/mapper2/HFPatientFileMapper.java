package com.zzyy.vhr.mapper2;

import com.zzyy.vhr.model2.HFPatientFile;
import com.zzyy.vhr.model2.zzyy_hf_patient_file_new;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HFPatientFileMapper {

    HFPatientFile getPatientFileDetail(@Param("patient_id") String patient_id);

    //int updateByPrimaryKeySelective(HFPatientFile record);

    int updateByPrimaryKey(HFPatientFile record);

    int updateSingleRecord(zzyy_hf_patient_file_new file_new);

    List<HFPatientFile> getRecordsBySql(String message);
}
