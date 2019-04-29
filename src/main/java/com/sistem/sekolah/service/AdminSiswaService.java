package com.sistem.sekolah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.sekolah.entity.Siswa;
import com.sistem.sekolah.repository.SiswaRepository;

@Service
public class AdminSiswaService {

	@Autowired
	SiswaRepository siswaRepository;

	public void save(Siswa siswa) {
		siswaRepository.save(siswa);
	}

	public List<Siswa> getAll() {
		return siswaRepository.findAll();
	}

	public Siswa getSiswa(int id) {
		return siswaRepository.getOne(id);
	}
	public void delete(Siswa siswa) {
		siswaRepository.delete(siswa);
	}
}
