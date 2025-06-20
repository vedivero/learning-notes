package com.ast.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.ProjectIssue;

public interface ProjectIssueRepository extends JpaRepository<ProjectIssue, Integer> {

}
