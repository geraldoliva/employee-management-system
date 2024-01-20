package com.geraldoliva.emsbackend.service;

import com.geraldoliva.emsbackend.dto.EmployeeDTO;
import com.geraldoliva.emsbackend.entity.Employee;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);
}
