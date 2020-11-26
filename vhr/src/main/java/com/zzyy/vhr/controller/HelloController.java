package com.zzyy.vhr.controller;

import com.zzyy.vhr.dto.Followup;
import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.model2.VisitRecord;
import com.zzyy.vhr.service.FollowupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String hello2()
    {
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3()
    {
        return "/employee/advanced/hello";
    }

    @Autowired
    private FollowupService followupService;


//    @GetMapping("/followup/{patient_id}")
//    public VisitRecord getFollowupById(@PathVariable("patient_id") String patient_id){
//        VisitRecord record = followupService.getFollowupById(patient_id);
//        return record;
//    }

    @PostMapping("/followup/")
    public RespBean addFollowup(@RequestBody Followup followup){
        if(followupService.addOneWeekFollowup(followup)==1)
            return RespBean.ok("添加成功!");
        else
            return RespBean.error("添加失败");

    }
    //更新
//    @PutMapping("/")
//    public RespBean updatePosition(@RequestBody Followup followup){
//        if(followupService.updatePosition(position)==1)
//            return RespBean.ok("更新成功!");
//        else
//            return RespBean.error("更新失败");
//    }

    @DeleteMapping("/followup/{id}")
    public RespBean deleteFollowupById(@PathVariable  Integer id){
        if(followupService.delOneWeekFollowup(id)==1)
            return RespBean.ok("删除成功!");
        else
            return RespBean.error("删除失败");
    }

    @PostMapping("/visitRecord/")
    public RespBean addVisitRecord(@RequestBody Followup followup){
        if(followupService.addOneWeekFollowup(followup)==1)
            return RespBean.ok("添加成功!");
        else
            return RespBean.error("添加失败");

    }

}
