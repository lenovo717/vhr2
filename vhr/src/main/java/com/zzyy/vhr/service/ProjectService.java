package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper.ProjectMapper;
import com.zzyy.vhr.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    public List<Project> getProjectsByDoctor(String doctor) {
        List<Project> projects = new ArrayList<Project>();
        for (Project proj: projectMapper.getProjectsByDoctor(doctor)) {
            if(!proj.getDoctor().equals("")){
                String[] arr = proj.getDoctor().split("\\|");
                if(Arrays.asList(arr).contains(doctor)){
                    projects.add(proj);
                }
            }
        }
        return projects;
    }

    /**
     *
     * fwq 20210111
     * @param doctor
     * @return
     */
    public List<Project> getAllProjectsByDoctor(String doctor) {

        List<Project> projects =  projectMapper.getAllProjectsByDoctor(doctor);
        return projects;
    }

}
