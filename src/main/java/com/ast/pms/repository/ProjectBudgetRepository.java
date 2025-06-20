package com.ast.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.ProjectBudget;

public interface ProjectBudgetRepository extends JpaRepository<ProjectBudget, Integer> {

}
