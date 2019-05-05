package com.sistem.sekolah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sistem.sekolah.entity.AppUser;
import com.sistem.sekolah.repository.UserAppRepository;
import com.sistem.sekolah.security.UserPrincipal;

@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private UserAppRepository userAppRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = userAppRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserPrincipal(user);
	}

}
