package com.ast.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.ProjectAttachment;

public interface ProjectAttachmentRepository extends JpaRepository<ProjectAttachment, Integer> {

}
