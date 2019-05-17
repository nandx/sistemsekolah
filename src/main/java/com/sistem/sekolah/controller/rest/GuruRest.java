package com.sistem.sekolah.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sistem.sekolah.entity.Guru;
import com.sistem.sekolah.repository.GuruRepository;

@RestController
public class GuruRest {

	@Autowired
	private GuruRepository guruRepository;

	@RequestMapping(value = "/rest/guru/list", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<List<Guru>> listGuru() {
		List<Guru> list = guruRepository.findAll();
		return new ResponseEntity<List<Guru>>(list, HttpStatus.OK);
	}

}
