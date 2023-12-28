package com.springbootAcademy.employeeservice.service;

import com.springbootAcademy.employeeservice.dto.ApiResponseDto;
import com.springbootAcademy.employeeservice.dto.EmployeeDto;
import com.springbootAcademy.employeeservice.entity.Employee;

public interface EmployeeService {
    EmployeeDto saveEmploye(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long id);
}
