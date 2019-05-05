package com.sistem.sekolah;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sistem.sekolah.entity.AppUser;
import com.sistem.sekolah.repository.UserAppRepository;
import com.sistem.sekolah.service.AppUserService;

@Component
public class InitialDB {

	@Autowired
	private UserAppRepository userAppRepository;
	@Autowired
	private AppUserService appUserService;

	@PostConstruct
	public void init() {
		System.out.println("======== init data ======== " + new Date());
		initAppUser("admin", "admin", "ADMIN");
		initAppUser("guru", "guru", "GURU");
		initAppUser("siswa", "siswa", "SISWA");
	}

	private void initAppUser(String username, String password, String role) {
		AppUser user = userAppRepository.findByUsername(username);
		if (user == null) {
			user = new AppUser();
			user.setUsername(username);
			user.setPassword(password);
			user.setUserrole(role);
			appUserService.createUser(user);
			;
		}
	}

}
