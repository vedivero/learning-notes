package com.ast.pms.repository.project;

import org.springframework.data.jpa.domain.Specification;

import com.ast.pms.domain.Project;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

public class ProjectSpecification {

    public static Specification<Project> containsKeywordInFields(String keyword) {
        return (root, query, cb) -> {

            String likePattern = "%" + keyword.toLowerCase() + "%";
            Join<Object, Object> projectEmployeeJoin = root.join("employees", JoinType.LEFT);
            Join<Object, Object> employeeJoin = projectEmployeeJoin.join("employee", JoinType.LEFT);

            query.distinct(true);

            return cb.or(
                    cb.like(cb.lower(root.get("name")), likePattern),
                    cb.like(cb.lower(root.get("status")), likePattern),
                    cb.and(
                            cb.isTrue(projectEmployeeJoin.get("isMainPm")),
                            cb.like(cb.lower(employeeJoin.get("name")), likePattern)));

        };
    }

}