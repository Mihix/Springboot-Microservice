package com.springbootAcademy.departmentservice.service;

import com.springbootAcademy.departmentservice.dto.DepartmentDto;
import com.springbootAcademy.departmentservice.entity.Department;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);
}
