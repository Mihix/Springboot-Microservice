package com.springbootAcademy.employeeservice.dto;

import com.springbootAcademy.employeeservice.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}
