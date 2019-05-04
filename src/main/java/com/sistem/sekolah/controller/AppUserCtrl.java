package com.sistem.sekolah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistem.sekolah.entity.AppUser;
import com.sistem.sekolah.service.AppUserService;

@Controller
public class AppUserCtrl {
	
	@Autowired
	AppUserService appUserService;
	
	@GetMapping("/admin/appuser")
	public String index(Model model) {
		List<AppUser> test = appUserService.getAll();
		model.addAttribute("list_AppUser", test);
		return "/admin/master_AppUser/master_AppUser_list";
	}
	
	@GetMapping("/admin/appuser/add")
	public String add(Model model) {
		model.addAttribute("dataUser", new AppUser());
		return "/admin/master_AppUser/master_AppUser_detail";
	}
	@PostMapping("/admin/appuser/save")
	public String save(Model model, @ModelAttribute AppUser appUser) {
		appUserService.save(appUser);
		return "redirect:";
	}
	@GetMapping("/admin/appuser/edit")
	public String edit(Model model, @RequestParam("idUser") Integer id) {
		AppUser appUser = appUserService.getGuru(id);
		model.addAttribute("dataUser", appUser);
		return "/admin/master_AppUser/master_AppUser_detail";
	}
}
