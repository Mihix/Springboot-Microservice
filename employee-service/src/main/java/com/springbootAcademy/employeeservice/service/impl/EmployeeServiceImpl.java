package com.springbootAcademy.employeeservice.service.impl;

import com.springbootAcademy.employeeservice.dto.ApiResponseDto;
import com.springbootAcademy.employeeservice.dto.DepartmentDto;
import com.springbootAcademy.employeeservice.dto.EmployeeDto;
import com.springbootAcademy.employeeservice.entity.Employee;
import com.springbootAcademy.employeeservice.repository.EmployeeRepository;
import com.springbootAcademy.employeeservice.service.APIClient;
import com.springbootAcademy.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
//@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private WebClient webClient;
    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmploye(EmployeeDto employeeDto) {

        //Employee type convert to entity type
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);//auto save method eka enne Jpa eke Repo eke tyenne

        //again cnvert to dto type, Beacause of when we do return , must convert to dto TYPE

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstname(),
                savedEmployee.getLastname(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        //Communicatio with Rest Template
//        ResponseEntity<DepartmentDto> responseEntity =
//                restTemplate.getForEntity("http://localhost:8082/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

        //Comunication with web client
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8082/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block(); //convert to synchronous communication


        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        ApiResponseDto apiResponseDto = new ApiResponseDto();

        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
