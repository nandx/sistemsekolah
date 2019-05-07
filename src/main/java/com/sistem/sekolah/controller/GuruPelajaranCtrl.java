package com.sistem.sekolah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuruPelajaranCtrl {

	@GetMapping("/guru/pelajaran")
	public String list() {
		return "/guru/pelajaran/guru_pelajaran_list";
	}

}
