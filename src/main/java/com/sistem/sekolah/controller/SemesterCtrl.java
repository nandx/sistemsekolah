package com.sistem.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistem.sekolah.entity.MasterSemester;
import com.sistem.sekolah.service.AdminGuruService;
import com.sistem.sekolah.service.AdminKelasService;
import com.sistem.sekolah.service.AdminPelajaranService;
import com.sistem.sekolah.service.MasterSemesterService;

@Controller
public class SemesterCtrl {

	@Autowired
	MasterSemesterService masterSemesterService;
	@Autowired
	AdminGuruService adminGuruService;
	@Autowired
	AdminPelajaranService adminPelajaranService;
	@Autowired
	AdminKelasService adminKelasService;

	@GetMapping("/admin/semester")
	public String indexSemester(Model model) {
		model.addAttribute("list_MasterSemester", masterSemesterService.getAll());
		return "/admin/master_semester/master_semester_list";
	}

	@GetMapping("/admin/masterSemester/edit")
	public String edit(Model model, @RequestParam("idMasterSemester") Integer idSemester) {
		MasterSemester masterSemester = masterSemesterService.getMasterSemester(idSemester);
		model.addAttribute("masterSemesterData", masterSemester);
		model.addAttribute("dataPelajaran", adminPelajaranService.getAll());

		model.addAttribute("dataGuru", adminGuruService.getList());
		model.addAttribute("dataKelas", adminKelasService.getAll());
		return "/admin/master_semester/master_semester_detail";
	}

	@GetMapping("/admin/masterSemester/add")
	public String add(Model model) {
		model.addAttribute("masterSemesterData", new MasterSemester());
		model.addAttribute("dataPelajaran", adminPelajaranService.getAll());
		model.addAttribute("dataGuru", adminGuruService.getList());
		model.addAttribute("dataKelas", adminKelasService.getAll());
		return "/admin/master_semester/master_semester_detail";
	}

	@PostMapping("/admin/masterSemester/save")
	public String save(Model model, @ModelAttribute MasterSemester masterSemester) {
		masterSemesterService.saveMasterSemester(masterSemester);
		return "redirect:/admin/semester";
	}
}
