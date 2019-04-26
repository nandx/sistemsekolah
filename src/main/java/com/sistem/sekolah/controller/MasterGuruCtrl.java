package com.sistem.sekolah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistem.sekolah.entity.Guru;
import com.sistem.sekolah.service.AdminGuruService;

@Controller
public class MasterGuruCtrl {

	@Autowired
	private AdminGuruService adminGuruService;

	@GetMapping("/admin/guru")
	public String list(Model model) {
		List<Guru> list = adminGuruService.getList();
		model.addAttribute("list_guru", list);
		return "/admin/master_guru/master_guru_list";
	}

	@GetMapping("/admin/guru/add")
	public String add(Model model) {
		model.addAttribute("data", new Guru());
		return "/admin/master_guru/master_guru_detail";
	}

	@PostMapping("/admin/guru/add")
	public String addSave(Model model, @ModelAttribute Guru guru) {
		System.out.println("guru : " + guru.getNamaGuru());
		adminGuruService.save(guru);
		return "redirect:";
	}

	@GetMapping("/admin/guru/edit")
	public String edit(Model model, @RequestParam("id") Integer paramid) {
		Guru guru = adminGuruService.getGuru(paramid);
		model.addAttribute("data", guru);
		return "/admin/master_guru/master_guru_detail";
	}

}
