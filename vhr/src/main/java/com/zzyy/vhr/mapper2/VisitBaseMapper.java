package com.zzyy.vhr.mapper2;

import com.zzyy.vhr.model2.VisitBase;
import com.zzyy.vhr.model2.VisitRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VisitBaseMapper {

    int insertVisitBase(VisitBase record);

    VisitBase getVisitBaseById(String base_id);

    int deleteByPrimaryKey(String base_id);

    int updateByPrimaryKeySelective(VisitBase base);

    List<VisitBase> getVisitBaseByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyword") String keyword);

    Long getTotal(String keyword);


}
