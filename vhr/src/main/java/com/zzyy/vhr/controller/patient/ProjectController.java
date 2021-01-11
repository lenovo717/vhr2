package com.zzyy.vhr.controller.patient;

import com.zzyy.vhr.model.Hr;
import com.zzyy.vhr.model.Project;
import com.zzyy.vhr.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proj")
public class ProjectController {

    @Autowired
    ProjectService projService;

    @GetMapping("/getAllByCurDoctor")
    public List<Project> getProjectsByCurDoctor(Authentication authentication){
        Hr hr = (Hr) authentication.getPrincipal();
        return projService.getProjectsByDoctor(hr.getUsername());
    }

    /**
     * fwq 20210111
     * @param authentication
     * @return
     */
    @GetMapping("/getProjectByCurDoctor")
    public List<Project> getProjectByCurDoctor(Authentication authentication){
        Hr hr = (Hr) authentication.getPrincipal();
        return projService.getAllProjectsByDoctor(hr.getUsername());
    }
}
