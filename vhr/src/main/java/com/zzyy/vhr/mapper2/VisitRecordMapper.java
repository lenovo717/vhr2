package com.zzyy.vhr.mapper2;

import com.zzyy.vhr.model2.VisitRecord;

import java.util.List;

public interface VisitRecordMapper {

    List<VisitRecord> getRecordsByArgs(VisitRecord conditionRecord);

    int insertVisitRecord(VisitRecord record);

    List<VisitRecord> getAllVisitRecord();

    List<VisitRecord> getRecordsBySql(String wheresql);

    List<VisitRecord> getRecordsByPatientId(String patient_id);

    VisitRecord getRecordById(String record_id);

    int deleteByPrimaryKey(String record_id);

    int updateByPrimaryKeySelective(VisitRecord record);

}
