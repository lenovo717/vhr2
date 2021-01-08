package com.zzyy.vhr.controller.patient;

import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model2.Patient;
import com.zzyy.vhr.model2.PatientMzDetail;
import com.zzyy.vhr.model3.EmrPatient;
import com.zzyy.vhr.service.EmrPatientService;
import com.zzyy.vhr.service.PatientMzDetailService;
import com.zzyy.vhr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emrpat/emrpatbasic")
public class EmrPatientController {
    @Autowired
    EmrPatientService patientService;


    @GetMapping("/")
    public RespPageBean getHisPatientByPage(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10 ") Integer size
            , String keyword)
    {
        return patientService.getEmrPatientByPage(page,size,keyword);
    }

    @GetMapping("/emrPatDetail")
    public EmrPatient getEmrPatientDetail(String patient_id,int times)
    {
        EmrPatient patient = new EmrPatient();

        //获取病人基本信息
        patient =  patientService.getPatientDetail(patient_id,times);

        return patient;
    }




}
