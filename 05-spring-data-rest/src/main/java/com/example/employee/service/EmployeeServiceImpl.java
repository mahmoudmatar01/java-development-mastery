package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
        Employee savedEmployee=Employee
                .builder()
                .firstName(employee.firstName())
                .lastName(employee.lastName())
                .build();
        repository.save(savedEmployee);
        return EmployeeDto.builder().id(savedEmployee.getId()).firstName(savedEmployee.getFirstName()).lastName(savedEmployee.getLastName()).build();
    }

    @Override
    public EmployeeDto removeEmployee(Long employeeId) {
        Employee employee=repository.findById(employeeId).orElseThrow(
                ()-> new RuntimeException("there is no employee with this id")
        );
        repository.delete(employee);
        return EmployeeDto.builder().id(employee.getId()).firstName(employee.getFirstName()).lastName(employee.getLastName()).build();
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee>employees=repository.findAll();
        return employees.stream().map(employee -> EmployeeDto.builder().id(employee.getId()).firstName(employee.getFirstName()).lastName(employee.getLastName()).build()).toList();
    }

    @Override
    public EmployeeDto getEmployeeById(Long Id) {
        Employee employee=repository.findById(Id).orElseThrow(
                ()-> new RuntimeException("there is no employee with this id")
        );
        return EmployeeDto.builder().id(employee.getId()).firstName(employee.getFirstName()).lastName(employee.getLastName()).build();
    }

    @Override
    public EmployeeDto updateEmployee(Long Id, EmployeeDto newEmployee) {
        Employee employee=repository.findById(Id).orElseThrow(
                ()-> new RuntimeException("there is no employee with this id")
        );
        employee.setId(newEmployee.id());
        employee.setFirstName(newEmployee.firstName());
        employee.setLastName(newEmployee.lastName());
        repository.save(employee);
        return EmployeeDto.builder().id(employee.getId()).firstName(employee.getFirstName()).lastName(employee.getLastName()).build();
    }
}
