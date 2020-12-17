package com.zzyy.vhr.mapper;

import com.zzyy.vhr.model.VisitRecord;
import org.apache.ibatis.annotations.Param;

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

    List<VisitRecord> getVistRecordByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyword") String keyword);

    Long getTotal(String keyword);

}
