package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper.DepartmentMapper;
import com.zzyy.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentByParentId(-1);
    }

    public void addDepartment(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDepartment(dep);
    }

    public Integer delDepartment(Department department) {
       return  departmentMapper.delDepartment(department);
    }
}
