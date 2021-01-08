package com.zzyy.vhr.mapper3;



import com.zzyy.vhr.model3.EmrPatient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmrPatientMapper {

    List<EmrPatient> getEmrPatientByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyword") String keyword);

    EmrPatient getEmrPatientInfo(@Param("patient_id") String patient_id,@Param("times") int time);
}
