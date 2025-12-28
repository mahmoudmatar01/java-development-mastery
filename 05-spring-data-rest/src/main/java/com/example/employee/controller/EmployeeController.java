package com.example.employee.controller;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto){
        var response=service.createEmployee(employeeDto);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto ,@PathVariable Long id){
        var response=service.updateEmployee(id,employeeDto);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeEmployee(@PathVariable Long id){
        var response=service.removeEmployee(id);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        var response=service.getEmployeeById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        var response=service.getAllEmployee();
        return ResponseEntity.ok(response);
    }
}
