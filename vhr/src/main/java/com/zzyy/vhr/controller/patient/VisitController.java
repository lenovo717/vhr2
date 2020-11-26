package com.zzyy.vhr.controller.patient;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzyy.vhr.dto.Followup;
import com.zzyy.vhr.dto.VisitRecordDTO;
import com.zzyy.vhr.model.Hr;
import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.model2.VisitRecord;
import com.zzyy.vhr.service.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    VisitRecordService recordService;

    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/recordsByPatientId/{patient_id}")
    public List<VisitRecord> getRecordsByPatientId(@PathVariable("patient_id") String patient_id){
        List<VisitRecord> records = recordService.getRecordsByPatientId(patient_id);
        return records;
    }

    @GetMapping("/record/{record_id}")
    public VisitRecord getRecordById(@PathVariable("record_id") String record_id){
        VisitRecord record = recordService.getRecordById(record_id);
        return record;
    }

    @PostMapping("/record/")
    public RespBean addVisitRecord(@RequestBody VisitRecord record){
        if(recordService.addRecord(record)==1)
            return RespBean.ok("添加成功!");
        else
            return RespBean.error("添加失败");
    }

    @PutMapping("/record/zz/")
    public RespBean updateZzRecord(@RequestBody VisitRecordDTO record) throws JsonProcessingException {
        VisitRecord curRecord = new VisitRecord();
        curRecord.setRecord_id(record.getRecord_id());
        String jsonString = mapper.writeValueAsString(record.getHzzz());
        curRecord.setHzzz(jsonString);
        if(recordService.updateRecord(curRecord)==1)
            return RespBean.ok("更新成功!");
        return RespBean.error("更新失败");
    }

    @PutMapping("/record/base/")
    public RespBean updateBaseRecord(@RequestBody VisitRecordDTO record) {
        VisitRecord curRecord = new VisitRecord();
        curRecord.setRecord_id(record.getRecord_id());
        curRecord.setRecord_type(record.getRecord_type());
        curRecord.setVist_time(record.getVist_time());
        curRecord.setSfxs(record.getSfxs());
        if(recordService.updateRecord(curRecord)==1)
            return RespBean.ok("更新成功!");
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/record/{id}")
    public RespBean deleteRecordById(@PathVariable String id)
    {
        if(recordService.delRecord(id)==1)
            return RespBean.ok("删除成功!");
        return RespBean.error("删除失败");
    }

    @GetMapping("/recordsByCondition/")
    public List<VisitRecord> getRecordsByCondition(@RequestBody VisitRecord record){
        return recordService.getRecordsByCondition(record);
    }
}
