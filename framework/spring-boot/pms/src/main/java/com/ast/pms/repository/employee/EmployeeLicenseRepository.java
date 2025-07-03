package com.ast.pms.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.Employee;
import com.ast.pms.domain.EmployeeLicense;

public interface EmployeeLicenseRepository extends JpaRepository<EmployeeLicense, Integer> {
    void deleteByEmployee(Employee employee);
}
