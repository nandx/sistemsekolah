package com.sistem.sekolah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistem.sekolah.entity.AppUser;
import com.sistem.sekolah.repository.UserAppRepository;

@Service
public class AppUserService {

	@Autowired
	UserAppRepository userAppRepository;

	public List<AppUser> getAll() {
		return userAppRepository.findAll();
	}

	public void createUser(AppUser appUser) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encryptedPassword = encoder.encode(appUser.getPassword());
		appUser.setPassword(encryptedPassword);
		userAppRepository.save(appUser);
	}

	public void save(AppUser appUser) {
		userAppRepository.save(appUser);
	}

	public AppUser getGuru(int id) {
		return userAppRepository.getOne(id);
	}
}
