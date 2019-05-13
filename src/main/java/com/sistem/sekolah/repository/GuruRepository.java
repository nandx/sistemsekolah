package com.sistem.sekolah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.sekolah.entity.Guru;

@Repository
public interface GuruRepository extends JpaRepository<Guru, Integer> {
	
}
