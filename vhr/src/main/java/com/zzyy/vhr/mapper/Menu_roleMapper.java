package com.zzyy.vhr.mapper;

import com.zzyy.vhr.model.Menu_role;
import org.apache.ibatis.annotations.Param;

public interface Menu_roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu_role record);

    int insertSelective(Menu_role record);

    Menu_role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu_role record);

    int updateByPrimaryKey(Menu_role record);

    void deleteByRid(Integer rid);

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}