package com.ast.pms.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.Project;
import com.ast.pms.domain.ProjectSubcontract;

public interface ProjectSubcontractRepository extends JpaRepository<ProjectSubcontract, Integer> {
    void deleteByProject(Project project);
}
