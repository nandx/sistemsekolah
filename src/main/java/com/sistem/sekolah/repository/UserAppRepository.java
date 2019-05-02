package com.sistem.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistem.sekolah.entity.AppUser;

public interface UserAppRepository extends JpaRepository<AppUser, Integer>{
	
}
