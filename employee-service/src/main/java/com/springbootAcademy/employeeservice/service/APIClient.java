package com.springbootAcademy.employeeservice.service;

import com.springbootAcademy.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8082",value = "DEPARTMENT-SERVICE" )
@FeignClient(url = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable(value = "department-code") String departmentCode);



}
