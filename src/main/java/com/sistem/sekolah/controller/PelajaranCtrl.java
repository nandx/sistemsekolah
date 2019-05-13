package com.sistem.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistem.sekolah.entity.Pelajaran;
import com.sistem.sekolah.service.AdminGuruService;
import com.sistem.sekolah.service.AdminPelajaranService;
import com.sistem.sekolah.service.SemesterKelasService;

@Controller
public class PelajaranCtrl {

	@Autowired
	AdminPelajaranService adminPelajaranService;

	@Autowired
	AdminGuruService adminGuruService;
	
	@Autowired
	SemesterKelasService semesterKelasService;
	
	
	@GetMapping("/admin/pelajaran")
	public String list(Model model) {
		// ambil semua data Pelajaran lalu kirim obj ke halaman dgn var list_pelajaran
		model.addAttribute("list_pelajaran", adminPelajaranService.getAll());
		return "/admin/master_pelajaran/master_pelajaran_list";
	}

	@GetMapping("/admin/pelajaran/add")
	public String add(Model model) {
		// kirim obj Pelajaran supaya di form bisa save
		model.addAttribute("pelajaran", new Pelajaran());
		model.addAttribute("list_guru", adminGuruService.getList());
		model.addAttribute("data", semesterKelasService.getAll());
		return "/admin/master_pelajaran/master_pelajaran_detail";
	}

	@PostMapping("/admin/pelajaran/save")
	public String save(Model model, @ModelAttribute Pelajaran pelajaran) {
		adminPelajaranService.save(pelajaran);
		return "redirect:";
	}

	@GetMapping("/admin/pelajaran/edit")
	public String edit(Model model, @RequestParam("idPelajaran") Integer idPelajaran) {
		Pelajaran pelajaran = adminPelajaranService.getPelajaran(idPelajaran);
		model.addAttribute("pelajaran", pelajaran);
		return "/admin/master_pelajaran/master_pelajaran_detail";
	}

}
