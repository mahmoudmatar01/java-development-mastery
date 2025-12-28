package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employee);
    EmployeeDto removeEmployee(Long employeeId);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getEmployeeById(Long Id);
    EmployeeDto updateEmployee(Long Id,EmployeeDto newEmployee);
}
