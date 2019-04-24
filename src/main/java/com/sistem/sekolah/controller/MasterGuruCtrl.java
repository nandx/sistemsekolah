package com.sistem.sekolah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
