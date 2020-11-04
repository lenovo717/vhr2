package com.zzyy.vhr.controller.system.basic;

import com.zzyy.vhr.model.Joblevel;
import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;
    @GetMapping("/")
    public List<Joblevel> getAllJobLevels(){

        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel)
    {
       if(jobLevelService.addJoblevel(joblevel)==1)
           return RespBean.ok("添加成功!");
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel)
    {
        if(jobLevelService.updateJoblevelById(joblevel)==1)
            return RespBean.ok("修改成功!");
        return RespBean.error("修改失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelBy(@PathVariable Integer id)
    {
        if(jobLevelService.deleteJoblevelById(id)==1)
            return RespBean.ok("删除成功!");
        return RespBean.error("删除失败!");
    }
}
