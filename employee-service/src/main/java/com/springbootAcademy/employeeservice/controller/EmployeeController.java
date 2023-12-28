package com.springbootAcademy.employeeservice.controller;

import com.springbootAcademy.employeeservice.dto.ApiResponseDto;
import com.springbootAcademy.employeeservice.dto.EmployeeDto;
import com.springbootAcademy.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto>saveEmployee(@RequestBody EmployeeDto employeeDto){
     EmployeeDto savedEmployee  = employeeService.saveEmploye(employeeDto);
     return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto>getEmployee(@PathVariable Long id){
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
    //getEmployeeId =  this method gives employeeDto + departmentDto (two of this)
}
