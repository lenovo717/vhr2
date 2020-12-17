package com.zzyy.vhr.mapper;

import com.zzyy.vhr.model.Project;

import java.util.List;

public interface ProjectMapper {

    List<Project> getProjectsByDoctor(String doctor);

}
