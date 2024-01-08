package com.geraldoliva.emsbackend.repository;

import com.geraldoliva.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
