package com.sistem.sekolah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.sekolah.entity.SemesterKelas;
import com.sistem.sekolah.repository.SemesterKelasRepository;

@Service
public class SemesterKelasService {

	@Autowired
	private SemesterKelasRepository kelasSemesterRepository;

	public void save(SemesterKelas semesterKelas) {
		kelasSemesterRepository.save(semesterKelas);
	}

	public List<SemesterKelas> getAll() {
		return kelasSemesterRepository.findAll();
	}

	public SemesterKelas getMasterSemester(Integer id) {
		return kelasSemesterRepository.getOne(id);
	}
}
