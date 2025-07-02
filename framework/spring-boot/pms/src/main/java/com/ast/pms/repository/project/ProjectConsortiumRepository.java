package com.ast.pms.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.Project;
import com.ast.pms.domain.ProjectConsortium;

public interface ProjectConsortiumRepository extends JpaRepository<ProjectConsortium, Integer> {
    void deleteByProject(Project project);
}
