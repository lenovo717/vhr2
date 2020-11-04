package com.zzyy.vhr.controller.emp;

import com.zzyy.vhr.model.RespPageBean;
import com.zzyy.vhr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page
            ,@RequestParam(defaultValue = "10 ") Integer size
            ,String keyword)
    {
         return employeeService.getEmployeeByPage(page,size,keyword);
    }


}
