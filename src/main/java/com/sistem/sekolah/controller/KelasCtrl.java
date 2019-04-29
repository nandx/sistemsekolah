package com.sistem.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistem.sekolah.entity.Kelas;

import com.sistem.sekolah.service.AdminKelasService;

@Controller
public class KelasCtrl {

	@Autowired
	private AdminKelasService kelasRepository;

	@GetMapping("/admin/kelas")
	public String index(Model Model) {
		Model.addAttribute("list_kelas", kelasRepository.getAll());
		return "/admin/master_kelas/master_kelas_list";
	}

	@GetMapping("/admin/kelas/add")
	public String addObject(Model model) {
		model.addAttribute("kelas", new Kelas());
		return "/admin/master_kelas/master_kelas_detail";
	}

	@PostMapping("/admin/kelas/save")
	public String save(Model model, @ModelAttribute Kelas dataKelas) {
		kelasRepository.save(dataKelas);
		return "redirect:/admin/kelas";
	}

	@GetMapping("/admin/kelas/edit")
	public String edit(Model model, @RequestParam("idKelas") Integer paramid) {
		Kelas kelas = kelasRepository.getKelas(paramid);
		model.addAttribute("kelas", kelas);
		return "/admin/master_kelas/master_kelas_detail";
	}
}
