package com.ast.pms.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.Project;
import com.ast.pms.domain.ProjectEmployee;

public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, Integer> {
    void deleteByProject(Project project);
}
