package com.zzyy.vhr.mapper;

import com.zzyy.vhr.model.Project;

import java.util.List;

public interface ProjectMapper {

    List<Project> getProjectsByDoctor(String doctor);

    /**
     * fwq 20210111
     * @param doctor
     * @return
     */
    List<Project> getAllProjectsByDoctor(String doctor);
}
