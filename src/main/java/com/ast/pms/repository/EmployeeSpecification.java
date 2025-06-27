package com.ast.pms.repository;

import com.ast.pms.domain.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> containsKeywordInFields(String keyword) {
        return (root, query, cb) -> {
            String likePattern = "%" + keyword.toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("name")), likePattern),
                    cb.like(cb.lower(root.get("team")), likePattern),
                    cb.like(cb.lower(root.get("position")), likePattern),
                    cb.like(cb.lower(root.get("level")), likePattern)
        };
    }
}
