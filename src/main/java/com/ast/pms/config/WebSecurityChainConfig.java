package com.ast.pms.config;

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

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebSecurityChainConfig {

	private final UserDetailsService userDetailsService;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
		return authConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public AuthenticationSuccessHandler successHandler() {
		return new SecurityLoginSuccessHandler();
	}

	public AuthenticationFailureHandler failureHandler() {
		return new SecurityLoginFailureHandler();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf
						.ignoringRequestMatchers("/logout") // CSRF 예외 처리
				)
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/main/**", "/join/**", "/account/**").authenticated() // 인증 필요
						.anyRequest().permitAll() // 그 외 모든 요청 허용
				)
				.formLogin(login -> login
						.loginPage("/login") // 사용자 정의 로그인 페이지
						.defaultSuccessUrl("/main") // 로그인 성공 후 이동할 페이지
						.successHandler(successHandler()) // 커스텀 성공 핸들러
						.failureHandler(failureHandler()) // 커스텀 실패 핸들러
				)
				.rememberMe(remember -> remember
						.rememberMeParameter("remember")
						.tokenValiditySeconds(259200) // 3일
						.userDetailsService(userDetailsService))
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login")
						.deleteCookies("JSESSIONID", "remember") // 쿠키 정리
				);

		return http.build();
	}

}