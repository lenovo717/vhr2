package com.zzyy.vhr.controller.patient;

import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model2.Patient;
import com.zzyy.vhr.model2.PatientMzDetail;
import com.zzyy.vhr.service.PatientMzDetailService;
import com.zzyy.vhr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hispat/hispatbasic")
public class PatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    PatientMzDetailService patientMzDetailService;

    @GetMapping("/")
    public RespPageBean getHisPatientByPage(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10 ") Integer size
            , String keyword)
    {
        return patientService.getHisPatientByPage(page,size,keyword);
    }

    @GetMapping("/diagnosis")
    public RespPageBean getPatientDiagnosisByPage(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10 ") Integer size
            , String keyword)
    {
        return patientService.getHisPatientDiagnosisByPage(page,size,keyword);
    }

    @GetMapping("/patDetail")
    public Patient getPatientDetail(String patient_id)
    {
        Patient patient = new Patient();
        //获取就诊记录
        List<PatientMzDetail> patientMzDetailList =  patientMzDetailService.getPatientVisitDetailByProcedure(patient_id,-1,0);
        //获取病人基本信息
        patient =  patientService.getPatientDetail(patient_id);
        if(patient != null)
            patient.setPatientMzDetailList(patientMzDetailList);
        return patient;
    }
}
