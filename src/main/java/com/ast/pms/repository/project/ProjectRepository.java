package com.ast.pms.repository.project;

import com.ast.pms.domain.Project;
import com.ast.pms.dto.response.project.ProjectListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT new com.ast.pms.dto.response.project.ProjectListResponse(" +
            "p.projectId, p.name, e.name, p.startDate, p.endDate, p.projectType, p.status) " +
            "FROM Project p " +
            "JOIN ProjectEmployee pe ON pe.project = p " +
            "JOIN Employee e ON pe.employee = e " +
            "WHERE pe.isMainPm = true")
    List<ProjectListResponse> findAllWithMainPm();
}
