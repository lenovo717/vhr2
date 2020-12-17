package com.zzyy.vhr.controller.patient;


import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model2.zzyy_hf_patient;
import com.zzyy.vhr.service.HFPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public zzyy_hf_patient getPatientDetail(String patient_id)
    {
        zzyy_hf_patient patient = new zzyy_hf_patient();
        //获取病人基本信息
        patient =  patientService.getPatientDetail(patient_id);
        return patient;
    }

    @PutMapping("/add")
    public RespBean addHFPatient(@RequestBody zzyy_hf_patient patient)
    {
        zzyy_hf_patient p = patientService.getPatientBySocialNo(patient.getSocialNo());
        if(p !=null)
            return RespBean.error("添加失败,该病人已建档!");
        patientService.addHFPatient(patient);
        if(patient.getResult()==1)
            return RespBean.ok("添加成功",patient);
        else
            return RespBean.error("添加失败");
    }


}
