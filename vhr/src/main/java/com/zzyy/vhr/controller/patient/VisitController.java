package com.zzyy.vhr.controller.patient;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzyy.vhr.dto.VisitRecordDTO;
import com.zzyy.vhr.model.Hr;
import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.model.VisitBase;
import com.zzyy.vhr.model.VisitRecord;
import com.zzyy.vhr.service.VisitBaseService;
import com.zzyy.vhr.service.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    VisitRecordService recordService;

    @Autowired
    VisitBaseService visitBaseService;

    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/recordsByPatientId/{patient_id}")
    public List<VisitRecord> getRecordsByPatientId(@PathVariable("patient_id") String patient_id){
        List<VisitRecord> records = recordService.getRecordsByPatientId(patient_id);
        return records;
    }

    @GetMapping("/recordsByPage/")
    public RespPageBean getVistRecordByPage(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10 ") Integer size
            , String keyword)
    {
        return recordService.getVistRecordByPage(page,size,keyword);
    }

    @GetMapping("/record/{record_id}")
    public VisitRecord getRecordById(@PathVariable("record_id") String record_id){
        VisitRecord record = recordService.getRecordById(record_id);
        return record;
    }

    @PostMapping("/record/")
    public RespBean addVisitRecord(@RequestBody VisitRecordDTO record) throws JsonProcessingException{
        VisitRecord curRecord = new VisitRecord();
        curRecord.setPatient_id(record.getPatient_id());
        // TODO: 通过患者信息查询患者姓名
        curRecord.setPatient_name("test");
        // TODO: 选择基线ID
        curRecord.setBase_id(1);
        // TODO: 根据基线ID设置项目ID
        curRecord.setProject_id("proj_1");
        curRecord.setStatus(1);
        curRecord.setRecord_type(record.getRecord_type());
        curRecord.setSfxs(record.getSfxs());
        curRecord.setVist_time(record.getVist_time());
        curRecord.setHzzz(mapper.writeValueAsString(record.getHzzz()));
//        curRecord.setRcjc(mapper.writeValueAsString(record.getRcjc()));
        curRecord.setShfs(mapper.writeValueAsString(record.getShfs()));
        curRecord.setTzytg(mapper.writeValueAsString(record.getTzytg()));
        curRecord.setJcjg(mapper.writeValueAsString(record.getJcjg()));
        curRecord.setZlyw_a(mapper.writeValueAsString(record.getZlyw_a()));
        curRecord.setZlyw_b(mapper.writeValueAsString(record.getZlyw_b()));
        if(recordService.addRecord(curRecord)==1)
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

    @PutMapping("/record/shfs/")
    public RespBean updateShfsRecord(@RequestBody VisitRecordDTO record) throws JsonProcessingException {
        VisitRecord curRecord = new VisitRecord();
        curRecord.setRecord_id(record.getRecord_id());
        String jsonString = mapper.writeValueAsString(record.getShfs());
        curRecord.setShfs(jsonString);
        if(recordService.updateRecord(curRecord)==1)
            return RespBean.ok("更新成功!");
        return RespBean.error("更新失败");
    }

    @PutMapping("/record/rcjc/")
    public RespBean updateRcjcRecord(@RequestBody VisitRecordDTO record) throws JsonProcessingException {
        VisitRecord curRecord = new VisitRecord();
        curRecord.setRecord_id(record.getRecord_id());
        String jsonString = mapper.writeValueAsString(record.getRcjc());
        curRecord.setRcjc(jsonString);
        if(recordService.updateRecord(curRecord)==1)
            return RespBean.ok("更新成功!");
        return RespBean.error("更新失败");
    }

    @PutMapping("/record/tzytg/")
    public RespBean updateTzytgRecord(@RequestBody VisitRecordDTO record) throws JsonProcessingException {
        VisitRecord curRecord = new VisitRecord();
        curRecord.setRecord_id(record.getRecord_id());
        String jsonString = mapper.writeValueAsString(record.getTzytg());
        curRecord.setTzytg(jsonString);
        if(recordService.updateRecord(curRecord)==1)
            return RespBean.ok("更新成功!");
        return RespBean.error("更新失败");
    }

    @PutMapping("/record/jcjg/")
    public RespBean updateJcjgRecord(@RequestBody VisitRecordDTO record) throws JsonProcessingException {
        VisitRecord curRecord = new VisitRecord();
        curRecord.setRecord_id(record.getRecord_id());
        String jsonString = mapper.writeValueAsString(record.getJcjg());
        curRecord.setJcjg(jsonString);
        if(recordService.updateRecord(curRecord)==1)
            return RespBean.ok("更新成功!");
        return RespBean.error("更新失败");
    }

    @PutMapping("/record/zlywA/")
    public RespBean updateZlywARecord(@RequestBody VisitRecordDTO record) throws JsonProcessingException {
        VisitRecord curRecord = new VisitRecord();
        curRecord.setRecord_id(record.getRecord_id());
        String jsonString = mapper.writeValueAsString(record.getZlyw_a());
        curRecord.setZlyw_a(jsonString);
        if(recordService.updateRecord(curRecord)==1)
            return RespBean.ok("更新成功!");
        return RespBean.error("更新失败");
    }

    @PutMapping("/record/zlywB/")
    public RespBean updateZlywBRecord(@RequestBody VisitRecordDTO record) throws JsonProcessingException {
        VisitRecord curRecord = new VisitRecord();
        curRecord.setRecord_id(record.getRecord_id());
        String jsonString = mapper.writeValueAsString(record.getZlyw_b());
        curRecord.setZlyw_b(jsonString);
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

    @GetMapping("/visitBaseByPage/")
    public RespPageBean getVistBaseByPage(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10 ") Integer size
            , String keyword)
    {
        return visitBaseService.getVisitBaseByPage(page,size,keyword);
    }

    @GetMapping("/visitBase/{base_id}")
    public VisitBase getVisitBaseById(@PathVariable("base_id") String base_id){
        VisitBase base = visitBaseService.getBaseById(base_id);
        return base;
    }

    @PutMapping("/visitBase/")
    public RespBean updateVisitBase(@RequestBody VisitBase record) throws JsonProcessingException {
        VisitBase curRecord = new VisitBase();
        curRecord.setBase_id(record.getBase_id());
        curRecord.setAddress(record.getAddress());
        curRecord.setProject_id(record.getProject_id());
        curRecord.setBase_name(record.getBase_name());
        curRecord.setBase_time(record.getBase_time());
        curRecord.setWeek_time(DateUtil.offsetDay(record.getBase_time(), 7));
        curRecord.setMonth_time(DateUtil.offsetMonth(record.getBase_time(), 1));
        curRecord.setHalfyear_time(DateUtil.offsetMonth(record.getBase_time(), 6));
        curRecord.setRemark(record.getRemark());
        if(visitBaseService.updateBase(curRecord)==1)
            return RespBean.ok("更新成功!");
        return RespBean.error("更新失败");
    }

    @PostMapping("/visitBase/")
    public RespBean addVisitBase(@RequestBody VisitBase record,Authentication authentication) throws JsonProcessingException{
        Hr hr = (Hr) authentication.getPrincipal();
        VisitBase curRecord = new VisitBase();
        curRecord.setPatient_id(record.getPatient_id());
        // TODO: 通过患者信息查询患者姓名
        curRecord.setPatient_name("test");
        curRecord.setAddress(record.getAddress());
        curRecord.setProject_id(record.getProject_id());
        curRecord.setBase_name(record.getBase_name());
        curRecord.setBase_time(record.getBase_time());
        curRecord.setWeek_time(DateUtil.offsetDay(record.getBase_time(), 7));
        curRecord.setMonth_time(DateUtil.offsetMonth(record.getBase_time(), 1));
        curRecord.setHalfyear_time(DateUtil.offsetMonth(record.getBase_time(), 6));
        curRecord.setRemark(record.getRemark());
        curRecord.setCreate_time(new Date());
        curRecord.setCreator(hr.getName());
        if(visitBaseService.addBase(curRecord)==1)
            return RespBean.ok("添加成功!");
        else
            return RespBean.error("添加失败");
    }

    @DeleteMapping("/visitBase/{id}")
    public RespBean deleteVisitBaseById(@PathVariable String id)
    {
        if(visitBaseService.delBase(id)==1)
            return RespBean.ok("删除成功!");
        return RespBean.error("删除失败");
    }
}
