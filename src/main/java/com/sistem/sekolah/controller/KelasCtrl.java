package com.sistem.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistem.sekolah.repository.KelasRepository;

@Controller
public class KelasCtrl {

	@Autowired
	private KelasRepository kelasRepository;

	@GetMapping("/admin/kelas")
	public String index(Model Model) {
		Model.addAttribute("list_kelas", kelasRepository.findAll());
		return "/admin/master_kelas/master_kelas_list";
	}
}
