package com.sistem.sekolah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.sekolah.entity.MasterSemester;
import com.sistem.sekolah.repository.MasterSemesterRepository;

@Service
public class MasterSemesterService {
	
	@Autowired
	MasterSemesterRepository masterSemesterRepository;
	
	public void saveMasterSemester(MasterSemester masterSemester) {
		masterSemesterRepository.save(masterSemester);
	}
	
	public List<MasterSemester> getAll(){
		return masterSemesterRepository.findAll();
	}
	public MasterSemester getMasterSemester(Integer id) {
		return masterSemesterRepository.getOne(id);
	}
}
