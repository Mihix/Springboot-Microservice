package com.springbootAcademy.employeeservice.repository;

import com.springbootAcademy.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
