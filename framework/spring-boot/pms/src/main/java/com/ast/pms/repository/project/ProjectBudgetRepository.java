package com.ast.pms.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.Project;
import com.ast.pms.domain.ProjectBudget;

public interface ProjectBudgetRepository extends JpaRepository<ProjectBudget, Integer> {
    void deleteByProject(Project project);
}
