package com.zzyy.vhr.mapper2;

import com.zzyy.vhr.model2.VisitBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VisitBaseMapper {

    List<VisitBase> selectByPatientId(String patient_id);

    int deleteByPrimaryKey(Integer base_id);

    int insert(VisitBase record);


}
