package com.geraldoliva.emsbackend.service.impl;

import com.geraldoliva.emsbackend.dto.EmployeeDTO;
import com.geraldoliva.emsbackend.entity.Employee;
import com.geraldoliva.emsbackend.exception.ResourceNotFoundException;
import com.geraldoliva.emsbackend.mapper.EmployeeMapper;
import com.geraldoliva.emsbackend.repository.EmployeeRepository;
import com.geraldoliva.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee does not exist with given id: " + employeeId));

        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployeeDTO) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with given id: " + employeeId));

        employee.setFirstName(updatedEmployeeDTO.getFirstName());
        employee.setLastName(updatedEmployeeDTO.getLastName());
        employee.setEmail(updatedEmployeeDTO.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(updatedEmployee);
    }
}
