package com.sistem.sekolah.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistem.sekolah.entity.AppUser;
import com.sistem.sekolah.security.UserPrincipal;
import com.sistem.sekolah.service.AppUserService;

@Controller
public class ChangePasswordCtrl {

	@Autowired
	AppUserService appUserService;

	@GetMapping("/changepassword")
	public String change(Model model, Principal principal) {
		Authentication auth = (UsernamePasswordAuthenticationToken) principal;
		UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
		AppUser appuser = userPrincipal.getAppUser();
		System.out.println("appuser - id : " + appuser.getId());
		System.out.println("appuser - user name : " + appuser.getUsername());
		model.addAttribute("data", appuser);
		return "/admin/changePassword";
	}

	@PostMapping("/changepassword/save")
	public String save(Model model, @ModelAttribute AppUser appUser) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encryptedPassword = encoder.encode(appUser.getPassword());
		appUser.setPassword(encryptedPassword);
		appUserService.save(appUser);
		return "redirect:/secure";
	}
}
