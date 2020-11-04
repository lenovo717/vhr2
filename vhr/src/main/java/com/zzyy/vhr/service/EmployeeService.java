package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper.EmployeeMapper;
import com.zzyy.vhr.model.Employee;
import com.zzyy.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public RespPageBean getEmployeeByPage(Integer page, Integer size, String keyword) {
        if(page !=null && size !=null){
            page = (page-1) *size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page,size,keyword);
        Long total = employeeMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }
}
