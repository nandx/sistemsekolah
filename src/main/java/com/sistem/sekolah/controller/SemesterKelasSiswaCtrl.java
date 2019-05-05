package com.sistem.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistem.sekolah.service.SemesterKelasSiswaService;

@Controller
public class SemesterKelasSiswaCtrl {
	
	@Autowired
	SemesterKelasSiswaService semesterKelasSiswaService;
	
	@GetMapping("/admin/semester-siswa")
	public String index(Model model) {
		model.addAttribute("dataSemesterKelasSiswa", semesterKelasSiswaService.getAll());
		return "/admin/master_SemesterKelasSiswa/master_SemesterKelasSiswa_list";
	}
	@GetMapping("/admin/semesterkelassiswa/edit")
	public String edit(Model model) {
		return "redirect";
	}
}
