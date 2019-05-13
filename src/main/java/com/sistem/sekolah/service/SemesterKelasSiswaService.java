package com.sistem.sekolah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sistem.sekolah.entity.SemesterKelasSiswa;
import com.sistem.sekolah.repository.MasterSemesterSiswaRepository;

@Service
public class SemesterKelasSiswaService {
	@Autowired
	MasterSemesterSiswaRepository masterSemesterSiswaRepository;

	public List<SemesterKelasSiswa> getAll() {
		return masterSemesterSiswaRepository.findAll();
	}

	public SemesterKelasSiswa save(SemesterKelasSiswa semesterKelasSiswa) {
		return masterSemesterSiswaRepository.save(semesterKelasSiswa);
	}

	public SemesterKelasSiswa getSemesterKelasSiswa(Integer id) {
		return masterSemesterSiswaRepository.getOne(id);
	}

	public List<SemesterKelasSiswa> findByMasterSemester(Integer id) {
		return masterSemesterSiswaRepository.findByMasterSemesterId(id);
	}
}
