package com.ast.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.ProjectEmployee;

public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, Integer> {

}
