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
				// .csrf(csrf -> csrf.ignoringRequestMatchers("/logout"));
				.csrf().disable()
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
						.userDetailsService(userDetailsService))
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login")
						.deleteCookies("JSESSIONID", "remember"));

		return http.build();
	}
}
