package com.zzyy.vhr.mapper2;


import com.zzyy.vhr.model2.HFPatient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HFPatientMapper {

    List<HFPatient> getPatientByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyword") String keyword);
    HFPatient getPatientDetail(@Param("patient_id") String patient_id);
}
