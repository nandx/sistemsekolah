package com.sistem.sekolah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.sekolah.entity.Guru;
import com.sistem.sekolah.repository.GuruRepository;

@Service
public class AdminGuruService {

	@Autowired
	private GuruRepository guruRepository;

	public List<Guru> getList() {
		return guruRepository.findAll();
	}

	public void save(Guru guru) {
		guruRepository.save(guru);
	}

	public Guru getGuru(int id) {
		return guruRepository.getOne(id);
	}

}
