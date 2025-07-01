package com.ast.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.Employee;
import com.ast.pms.domain.License;

public interface EmployeeLicenseRepository extends JpaRepository<License, Integer> {
    void deleteByEmployee(Employee employee);
}
