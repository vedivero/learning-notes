package com.ast.pms.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@RequiredArgsConstructor
public class WebSecurityChainConfig {

	// Employee 기반 사용자 인증 서비스
	private final UserDetailsService employeeDetailsService;

	// 인증 관리자 Bean 등록
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
		return authConfiguration.getAuthenticationManager();
	}

	// 비밀번호 암호화 (BCrypt 사용)
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 로그인 성공 핸들러
	public AuthenticationSuccessHandler successHandler() {
		return new SecurityLoginSuccessHandler();
	}

	// 로그인 실패 핸들러
	public AuthenticationFailureHandler failureHandler() {
		return new SecurityLoginFailureHandler();
	}

	// 스프링 시큐리티 필터 체인 설정
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.ignoringRequestMatchers("/logout"))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/main/**", "/account/**").authenticated()
						.anyRequest().permitAll())
				.formLogin(login -> login
						.loginPage("/login")
						.defaultSuccessUrl("/main")
						.successHandler(successHandler())
						.failureHandler(failureHandler())
						.usernameParameter("id")
						.passwordParameter("password"))
				.rememberMe(remember -> remember
						.rememberMeParameter("remember")
						.tokenValiditySeconds(259200)
						.userDetailsService(employeeDetailsService))
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login")
						.deleteCookies("JSESSIONID", "remember"));

		return http.build();
	}
}
