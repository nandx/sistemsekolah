package com.sistem.sekolah.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sistem.sekolah.entity.Pelajaran;
import com.sistem.sekolah.repository.PelajaranRepository;

@RestController
public class PelajaranRest {

	@Autowired
	private PelajaranRepository pelajaranRepository;

	@RequestMapping(value = "/rest/pelajaran/list", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<List<Pelajaran>> listGuru() {
		Pageable pageable = PageRequest.of(0, 10);// ini paging
		Page<Pelajaran> page = pelajaranRepository.findAll(pageable);
		return new ResponseEntity<List<Pelajaran>>(page.getContent(), HttpStatus.OK);
	}

}
