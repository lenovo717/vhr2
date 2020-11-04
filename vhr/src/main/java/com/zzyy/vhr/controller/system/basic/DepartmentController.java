package com.zzyy.vhr.controller.system.basic;


import com.zzyy.vhr.model.Department;
import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments()
    {
       return  departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public RespBean addDepartment(@RequestBody Department dep)
    {
        departmentService.addDepartment(dep);
        if(dep.getResult()==1)
            return RespBean.ok("添加成功",dep);
        else
            return RespBean.error("添加失败");
    }
  @DeleteMapping("/{id}")
    public RespBean delDepartment(@PathVariable Integer id)
    {
       Department department = new Department();
       department.setId(id);
        departmentService.delDepartment(department);
       if(department.getResult()==-2)
           return RespBean.error("有子部门存在，不能删除");
       else if(department.getResult()==-1)
           return RespBean.error("有员工存在，不能删除");
       else if(department.getResult()==1)
           return RespBean.ok("删除成功!");

       return RespBean.error("删除失败！");
    }

}
