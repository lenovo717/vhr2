package com.zzyy.vhr.controller.patient;

import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model.zzyy_hf_qy;
import com.zzyy.vhr.model2.Patient;
import com.zzyy.vhr.model2.PatientMzDetail;
import com.zzyy.vhr.service.HFqyService;
import com.zzyy.vhr.service.PatientMzDetailService;
import com.zzyy.vhr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pat/qyList")
public class HFqyController {
    @Autowired
    HFqyService hFqyService;



    @GetMapping("/")
    public List<zzyy_hf_qy> getQyList()
    {

        List<zzyy_hf_qy> patientMzDetailList = hFqyService.getList();

        return patientMzDetailList;
    }
}
