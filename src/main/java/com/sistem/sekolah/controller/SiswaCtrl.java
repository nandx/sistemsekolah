package com.sistem.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistem.sekolah.entity.Siswa;
import com.sistem.sekolah.service.AdminSiswaService;

@Controller
public class SiswaCtrl {

	@Autowired
	AdminSiswaService adminSiswaService;

	@GetMapping("/admin/siswa")
	public String getAll(Model model) {
		model.addAttribute("list_siswa", adminSiswaService.getAll());
		return "/admin/master_siswa/master_siswa_list";
	}

	@GetMapping("/admin/siswa/add")
	public String add(Model model) {
		model.addAttribute("siswa", new Siswa());
		return "/admin/master_siswa/master_siswa_detail";
	}

	@PostMapping("/admin/siswa/save")
	public String save(Model model, @ModelAttribute Siswa siswa) {
		adminSiswaService.save(siswa);
		return "redirect:";
	}

	@GetMapping("/admin/siswa/edit")
	public String edit(Model model, @RequestParam("idSiswa") Integer id) {
		Siswa siswa = adminSiswaService.getSiswa(id);
		model.addAttribute("siswa", siswa);
		return "/admin/master_siswa/master_siswa_detail";
	}
}
