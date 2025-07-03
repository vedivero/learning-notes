package com.ast.pms.repository.employee;

import com.ast.pms.domain.Employee;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> containsKeywordInFields(String keyword) {
        return (root, query, cb) -> {
            String likePattern = "%" + keyword.toLowerCase() + "%";

            Join<Object, Object> licensesJoin = root.join("licenses", JoinType.LEFT);

            return cb.or(
                    cb.like(cb.lower(root.get("name")), likePattern),
                    cb.like(cb.lower(root.get("team")), likePattern),
                    cb.like(cb.lower(root.get("position")), likePattern),
                    cb.like(cb.lower(root.get("level")), likePattern),
                    cb.like(cb.lower(root.get("workType")), likePattern),
                    cb.like(cb.lower(root.get("role")), likePattern),
                    cb.like(cb.lower(licensesJoin.get("name")), likePattern));
        };
    }
}
