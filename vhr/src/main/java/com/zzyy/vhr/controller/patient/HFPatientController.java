package com.zzyy.vhr.controller.patient;

import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model2.HFPatient;
import com.zzyy.vhr.service.HFPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pat/patbasic")
public class HFPatientController {
    @Autowired
    HFPatientService patientService;

    @GetMapping("/")
    public RespPageBean getPatientByPage(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10 ") Integer size
            , String keyword)
    {
        return patientService.getPatientByPage(page,size,keyword);
    }

    @GetMapping("/patDetail")
    public HFPatient getPatientDetail(String patient_id)
    {
        HFPatient patient = new HFPatient();
        //获取病人基本信息
        patient =  patientService.getPatientDetail(patient_id);
        return patient;
    }


}
