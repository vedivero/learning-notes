package com.ast.pms.config;

import com.ast.pms.domain.Account;
import com.ast.pms.repository.AuthRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = authRepository.findByLoginId(loginId);

        if (optionalAccount.isEmpty()) {
            throw new UsernameNotFoundException("해당 계정이 존재하지 않습니다: " + loginId);
        }

        Account account = optionalAccount.get();
        System.out.println("================================================================================");
        System.out.println("■ 로그인 시도: " + account.getLoginId());
        System.out.println("■ 비밀번호(암호화됨): " + account.getPassword());
        System.out.println("■ 활성화 상태: " + account.isEnabled());
        System.out.println("■ 권한: " + account.getRole());
        System.out.println("================================================================================");

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(account.getRole()));

        return new User(
                account.getLoginId(),
                account.getPassword(),
                account.isEnabled(),
                true,
                true,
                true,
                grantedAuthorities);
    }
}
