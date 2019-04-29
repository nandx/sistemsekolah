package com.sistem.sekolah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.sekolah.entity.Kelas;
import com.sistem.sekolah.repository.KelasRepository;

@Service
public class AdminKelasService {

	@Autowired
	KelasRepository kelasRepository;

	public void save(Kelas kelas) {
		kelasRepository.save(kelas);
	}

	public List<Kelas> getAll() {
		return kelasRepository.findAll();
	}

	public Kelas getKelas(int id) {
		return kelasRepository.getOne(id);
	}

	public void delete(Kelas kelas) {
		kelasRepository.delete(kelas);
	}
}
