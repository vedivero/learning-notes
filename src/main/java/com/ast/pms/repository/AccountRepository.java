package com.ast.pms.repository;

import com.ast.pms.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    // Optional<Employee> findByLoginId(String loginId);
}
