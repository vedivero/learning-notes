package com.ast.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.ProjectLocation;

public interface ProjectLocationRepository extends JpaRepository<ProjectLocation, Integer> {

}
