package com.zzyy.vhr.mapper2;

import com.zzyy.vhr.model2.Project;
import com.zzyy.vhr.model2.VisitRecord;

import java.util.List;

public interface ProjectMapper {

    List<Project> getProjectsByDoctor(String doctor);

}
