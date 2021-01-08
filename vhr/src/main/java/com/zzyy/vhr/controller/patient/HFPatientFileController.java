package com.zzyy.vhr.controller.patient;

import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.model2.HFPatientFile;
import com.zzyy.vhr.model2.Patient;
import com.zzyy.vhr.model2.zzyy_hf_patient;
import com.zzyy.vhr.model2.zzyy_hf_patient_file_new;
import com.zzyy.vhr.service.HFPatientFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pat/patFile")
public class HFPatientFileController {

    @Autowired
    HFPatientFileService patientFileService;

    @GetMapping("/patDetail")
    public HFPatientFile getPatientDetail(String patient_id)
    {
        HFPatientFile patient = new HFPatientFile();
        //获取病人基本信息
        patient =  patientFileService.getPatientFileDetail(patient_id);
        return patient;
    }

    @GetMapping("/patFileInfo")
    public List<zzyy_hf_patient_file_new>  getPatientFileInfos(String file_id)
    {

        //获取病人基本信息
        List<zzyy_hf_patient_file_new> infoList =  patientFileService.getPatientFileInfos(file_id);
        return infoList;
    }




    @PostMapping("/patFileList")
    public List<HFPatientFile> getPatientFileList(@RequestBody HFPatientFile hfPatientFile)
    {

        //获取病人基本信息
        List<HFPatientFile> list =  patientFileService.getPatientFileList(hfPatientFile);
        return list;
    }
    @PutMapping("/")
    public RespBean updateHFPatient(@RequestBody HFPatientFile hfPatientFile)
    {
        if(patientFileService.updateHFPatientFileById(hfPatientFile)==1)
            return RespBean.ok("修改成功!");
        return RespBean.error("修改失败!");
    }


    @PostMapping("/patQryFileList")
    public List<zzyy_hf_patient> getPatientFileList(@RequestBody List<String> qryCondition)
    {
        //获取病人基本信息
        return   patientFileService.getPatientQryFileList(qryCondition);

    }

    @PutMapping("/updateFile/{fileId}/{patientId}/{class}")
    public RespBean updateHFPatientFile(@PathVariable("fileId") String fileId,
                                        @PathVariable("patientId") String patientId,
                                        @PathVariable("class") String className,
                                        @RequestBody Map<String,String> mapValue)
    {

        if(patientFileService.batchInsertFile(fileId,patientId,className,mapValue)>0)
           return RespBean.ok("修改成功!");
        return RespBean.error("修改失败!");
    }
}
