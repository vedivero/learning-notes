package com.ast.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ast.pms.domain.Account;

public interface AuthRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByLoginId(String loginId);
}
