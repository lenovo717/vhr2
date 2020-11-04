package com.zzyy.vhr.mapper2;


import com.zzyy.vhr.model2.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {

    List<Patient> getPatientByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyword") String keyword);
    List<Patient> getPatientDiagnosisByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyword") String keyword);

    List<Patient> getPatientByProcedure(@Param("dept_sn") String dept_sn,@Param("qry_date") String qry_date);
    List<Patient> getPatientVisitDetailByProcedure(@Param("patient_id") String patient_id,
                                                   @Param("times") Integer times,
                                                   @Param("year") Integer year);
    Patient getPatientDetail(@Param("patient_id") String patient_id);
}
