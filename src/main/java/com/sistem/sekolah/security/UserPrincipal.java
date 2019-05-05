package com.sistem.sekolah.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sistem.sekolah.entity.AppUser;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = -239281642285048833L;
	private AppUser appUser;
	private List<GrantedAuthority> listAuth;

	public UserPrincipal(AppUser user) {
		this.appUser = user;
		this.listAuth = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getUserrole());
		listAuth.add(grantedAuthority);
	}

	public AppUser getAppUser() {
		return appUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return listAuth;
	}

	@Override
	public String getPassword() {
		return appUser.getPassword();
	}

	@Override
	public String getUsername() {
		return appUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
