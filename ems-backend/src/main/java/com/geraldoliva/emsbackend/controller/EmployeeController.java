package com.geraldoliva.emsbackend.controller;

import com.geraldoliva.emsbackend.dto.EmployeeDTO;
import com.geraldoliva.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployeeDTO =  employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    // Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employeesDTO = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeesDTO);
    }

    @PutMapping("{id}")
    // Build Update Employee REST API
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDTO updatedEmployeeDTO) {
        EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployeeDTO);
        return ResponseEntity.ok(employeeDTO);
    }

}
