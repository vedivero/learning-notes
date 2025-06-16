package com.ast.pms.service.employee;

import com.ast.pms.domain.Employee;
import com.ast.pms.repository.employee.EmployeeRepository;

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
public class EmployeeDetailsServiceImpl implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findByLoginId(loginId);

        if (optionalEmployee.isEmpty()) {
            throw new UsernameNotFoundException("해당 사원이 존재하지 않습니다: " + loginId);
        }

        Employee employee = optionalEmployee.get();
        System.out.println("================================================================================");
        System.out.println("■ 로그인 시도: " + employee.getLoginId());
        System.out.println("■ 비밀번호(암호화됨): " + employee.getPassword());
        System.out.println("■ 활성화 상태: " + employee.isEnabled());
        System.out.println("■ 권한: " + employee.getRole());
        System.out.println("================================================================================");

        // 권한 세팅 (단일 권한이지만 Set으로 작성)
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(employee.getRole())); // 예: ROLE_USER

        return new User(
                employee.getLoginId(), // username
                employee.getPassword(), // password
                employee.isEnabled(), // enabled
                true, // accountNonExpired
                true, // credentialsNonExpired
                true, // accountNonLocked
                grantedAuthorities // 권한 목록
        );
    }
}
