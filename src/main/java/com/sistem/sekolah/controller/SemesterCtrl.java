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
public class SemesterCtrl {

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

	@GetMapping("/admin/semester")
	public String indexSemester(Model model) {
		model.addAttribute("list_MasterSemester", masterSemesterService.getAll());
		return "/admin/master_semester/master_semester_list";
	}

	@GetMapping("/admin/semester/edit")
	public String edit(Model model, @RequestParam("idMasterSemester") Integer idSemester) {
		SemesterKelas masterSemester = masterSemesterService.getMasterSemester(idSemester);
		model.addAttribute("masterSemesterData", masterSemester);
		model.addAttribute("dataPelajaran", adminPelajaranService.getAll());
		model.addAttribute("dataGuru", adminGuruService.getList());
		model.addAttribute("dataKelas", adminKelasService.getAll());
		return "/admin/master_semester/master_semester_detail";
	}

	@GetMapping("/admin/semester/add")
	public String add(Model model) {
		model.addAttribute("masterSemesterData", new SemesterKelas());
		model.addAttribute("dataPelajaran", adminPelajaranService.getAll());
		model.addAttribute("dataGuru", adminGuruService.getList());
		model.addAttribute("dataKelas", adminKelasService.getAll());
		return "/admin/master_semester/master_semester_detail";
	}

	@PostMapping("/admin/semester/save")
	public String save(Model model, @ModelAttribute SemesterKelas masterSemester) {
		masterSemesterService.save(masterSemester);
		return "redirect:/admin/semester";
	}

	@PostMapping("/admin/semestersiswa/save")
	public String saveSemesterKelasSiswaSave(Model model, @ModelAttribute SemesterKelasSiswa masterSemester) {
		semesterKelasSiswaService.save(masterSemester);
		return "redirect:/admin/semester";
	}

	@GetMapping("/admin/semester/siswa")
	public String semestersiswa(Model model, @RequestParam("id") Integer idSemester) {
		SemesterKelas masterSemester = masterSemesterService.getMasterSemester(idSemester);
		SemesterKelasSiswa ssk = new SemesterKelasSiswa();
		semesterKelasSiswaService.getSemesterKelasSiswa(idSemester);
		ssk.setMasterSemester(masterSemester);
		model.addAttribute("masterSemesterData", masterSemester);
		model.addAttribute("Siswa", adminSiswaService.getAll());
		model.addAttribute("dataNew", semesterKelasSiswaService.getAll());

		model.addAttribute("allMasterSemester", semesterKelasSiswaService.findByMasterSemester(idSemester));
		return "/admin/master_semester/master_semester_siswa";
	}
}
