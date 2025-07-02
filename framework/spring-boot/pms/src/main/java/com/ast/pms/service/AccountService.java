package com.ast.pms.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ast.pms.repository.AccountRepository;

import com.ast.pms.domain.Account;
import com.ast.pms.dto.request.AccountRegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(AccountRegisterRequest request) {

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        Account account = Account.builder()
                .loginId(request.getLoginId())
                .password(encodedPassword)
                .userName(request.getUserName())
                .role(request.getRole())
                .passwordChangedAt(request.getPasswordChangedAt())
                .accountEnabled(true)
                .build();

        accountRepository.save(account);
    }
}
