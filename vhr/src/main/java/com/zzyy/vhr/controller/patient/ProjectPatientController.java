package com.zzyy.vhr.controller.patient;

import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model2.Patient;
import com.zzyy.vhr.model2.PatientMzDetail;
import com.zzyy.vhr.model2.zzyy_hf_patient;
import com.zzyy.vhr.model2.zzyy_hf_project_patient;
import com.zzyy.vhr.service.HFPatientService;
import com.zzyy.vhr.service.HFProjectPatService;
import com.zzyy.vhr.service.PatientMzDetailService;
import com.zzyy.vhr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectPat")
public class ProjectPatientController {
    @Autowired
    HFProjectPatService projectPatService;




    @PutMapping("/add")
    public RespBean addHFPatient(@RequestBody zzyy_hf_project_patient patient)
    {

                zzyy_hf_project_patient p = projectPatService.getPatientByFileId(patient.getPatientId());
                if(p !=null)
                    return RespBean.error("添加失败,该病人已在该项目中!");

                patient.setPatientStatus(0);
                if(projectPatService.addProjectPat(patient)>=1)
                    return RespBean.ok("添加成功",patient);
                else
                    return RespBean.error("添加失败");
    }




}
