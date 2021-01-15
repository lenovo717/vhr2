package com.zzyy.vhr.controller.patient;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzyy.vhr.model.Hr;
import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model.VisitBase;
import com.zzyy.vhr.model2.zzyy_hf_patient;
import com.zzyy.vhr.service.HFPatientService;
import com.zzyy.vhr.service.VisitBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/visitbase")
public class VisitBaseController {

    @Autowired
    VisitBaseService visitBaseService;

    @Autowired
    HFPatientService patientService;

    @GetMapping("/getByProjAndPatient/")
    public RespPageBean getVistBaseByPage(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10 ") Integer size
            , String project_id, String patient_id, Authentication authentication)
    {
        Hr hr = (Hr) authentication.getPrincipal();
        return visitBaseService.getVisitBasesByPage(page,size,hr.getUsername(), project_id, patient_id);
    }

    @GetMapping("/getPatientsInProj")
    public List<zzyy_hf_patient> getPatientsInProj(){
        List<zzyy_hf_patient> list = patientService.getPatientsInProj();
        return list;
    }

    @PostMapping("/add")
    public RespBean addVisitBase(@RequestBody VisitBase record, Authentication authentication) throws JsonProcessingException {
        Hr hr = (Hr) authentication.getPrincipal();
        VisitBase curRecord = new VisitBase();
        curRecord.setProj_pati_id(record.getProj_pati_id());
        curRecord.setFile_id(record.getFile_id());
        curRecord.setPatient_name(record.getPatient_name());
        curRecord.setProject_id(record.getProject_id());
        curRecord.setBase_name(record.getBase_name());
        curRecord.setBase_time(record.getBase_time());
        curRecord.setWeek_time(DateUtil.offsetDay(record.getBase_time(), 7));
        curRecord.setMonth_time(DateUtil.offsetMonth(record.getBase_time(), 1));
        curRecord.setHalfyear_time(DateUtil.offsetMonth(record.getBase_time(), 6));
        curRecord.setRemark(record.getRemark());
        curRecord.setBelongs(hr.getUsername());
        curRecord.setCreate_time(new Date());
        curRecord.setCreator(hr.getName());
        if(visitBaseService.addBase(curRecord)==1)
            return RespBean.ok("添加成功!");
        else
            return RespBean.error("添加失败");
    }

    @PutMapping("/update")
    public RespBean updateVisitBase(@RequestBody VisitBase record, Authentication authentication) throws JsonProcessingException {
        Hr hr = (Hr) authentication.getPrincipal();
        VisitBase curRecord = new VisitBase();
        curRecord.setBase_id(record.getBase_id());
        curRecord.setProject_id(record.getProject_id());
        curRecord.setBase_name(record.getBase_name());
        curRecord.setBase_time(record.getBase_time());
        curRecord.setBelongs(hr.getUsername());
        curRecord.setWeek_time(DateUtil.offsetDay(record.getBase_time(), 7));
        curRecord.setMonth_time(DateUtil.offsetMonth(record.getBase_time(), 1));
        curRecord.setHalfyear_time(DateUtil.offsetMonth(record.getBase_time(), 6));
        curRecord.setRemark(record.getRemark());
        if(visitBaseService.updateBase(curRecord)==1)
            return RespBean.ok("更新成功!");
        return RespBean.error("更新失败");
    }
}
