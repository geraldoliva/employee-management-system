package com.geraldoliva.emsbackend.service.impl;

import com.geraldoliva.emsbackend.dto.EmployeeDTO;
import com.geraldoliva.emsbackend.entity.Employee;
import com.geraldoliva.emsbackend.mapper.EmployeeMapper;
import com.geraldoliva.emsbackend.repository.EmployeeRepository;
import com.geraldoliva.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }
}
