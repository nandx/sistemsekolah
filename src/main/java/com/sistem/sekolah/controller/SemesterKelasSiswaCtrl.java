package com.sistem.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistem.sekolah.entity.SemesterKelas;
import com.sistem.sekolah.entity.SemesterKelasSiswa;
import com.sistem.sekolah.service.AdminGuruService;
import com.sistem.sekolah.service.AdminKelasService;
import com.sistem.sekolah.service.AdminPelajaranService;
import com.sistem.sekolah.service.AdminSiswaService;
import com.sistem.sekolah.service.SemesterKelasService;
import com.sistem.sekolah.service.SemesterKelasSiswaService;

@Controller
public class SemesterKelasSiswaCtrl {

	@Autowired
	SemesterKelasService masterSemesterService;
	@Autowired
	AdminGuruService adminGuruService;
	@Autowired
	AdminPelajaranService adminPelajaranService;
	@Autowired
	AdminKelasService adminKelasService;
	@Autowired
	AdminSiswaService adminSiswaService;
	@Autowired
	SemesterKelasSiswaService semesterKelasSiswaService;
	@Autowired
	SemesterKelasService semesterKelasService;

	@GetMapping("/admin/semester-siswa")
	public String index(Model model) {
		model.addAttribute("dataSemesterKelasSiswa", semesterKelasSiswaService.getAll());
		return "/admin/master_SemesterKelasSiswa/master_SemesterKelasSiswa_list";
	}

	@GetMapping("/admin/semesterkelassiswa/edit")
	public String edit(Model model, @RequestParam("idsemesterkelassiswa") Integer id) {
		SemesterKelasSiswa sks = semesterKelasSiswaService.getSemesterKelasSiswa(id);
		model.addAttribute("dataSemesterKelasSiswa", sks);
		model.addAttribute("dataSemester", masterSemesterService.getAll());
		model.addAttribute("dataSiswa", adminSiswaService.getAll());
		return "/admin/master_SemesterKelasSiswa/master_SemesterKelasSiswa_detail";
	}
	@PostMapping("/admin/semesterKelas/save")
	public String save(@ModelAttribute SemesterKelasSiswa sks) {
		semesterKelasSiswaService.save(sks);
		return "redirect:/admin/semester-siswa";
	}
}
