package com.zzyy.vhr.mapper2;


import com.zzyy.vhr.model2.PatientMzDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMzDetailMapper {

    List<PatientMzDetail> getPatientVisitDetailByProcedure(@Param("patient_id") String patient_id,
                                                           @Param("times") Integer times,
                                                           @Param("year") Integer year);
}
