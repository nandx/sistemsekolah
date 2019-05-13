package com.sistem.sekolah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sistem.sekolah.entity.Pelajaran;
import com.sistem.sekolah.repository.PelajaranRepository;

@Service
public class AdminPelajaranService {

	@Autowired
	PelajaranRepository pelajaranRepository;

	public List<Pelajaran> getAll() {
		return pelajaranRepository.findAll();
	}

	public void save(Pelajaran pelajaran) {
		pelajaranRepository.save(pelajaran);
	}

	public Pelajaran getPelajaran(int id) {
		return pelajaranRepository.getOne(id);
	}
	public void delete(Pelajaran pelajaran) {
		pelajaranRepository.delete(pelajaran);
	}
}
