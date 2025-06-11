package com.ast.pms.config;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	// private final UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// Optional<UserVO> ouser = userService.getOne(username);
		// Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		// if (ouser.isPresent()) {
		// UserVO user = ouser.get();
		// grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

		// return new User(user.getUserName(), user.getPassword(), true, true, true,
		// true, grantedAuthorities);
		// } else {
		// throw new UsernameNotFoundException(username);
		// }
		return null;
	}

}
