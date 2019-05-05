package com.sistem.sekolah.controller;

import java.security.Principal;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistem.sekolah.entity.AppUser;
import com.sistem.sekolah.security.UserPrincipal;

@Controller
public class SecureCtrl {

	@GetMapping("/secure")
	public String secure(Principal principal) {
		Authentication auth = (UsernamePasswordAuthenticationToken) principal;
		UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
		AppUser appuser = userPrincipal.getAppUser();
		String role = appuser.getUserrole();
		if (role != null) {
			if ("ADMIN".equals(role)) {
				return "redirect:/admin/guru";
			} else if ("GURU".equals(role)) {
				return "redirect:/guru";
			}
		}
		return "redirect:/logout";
	}

}
