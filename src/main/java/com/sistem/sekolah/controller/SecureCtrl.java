package com.sistem.sekolah.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureCtrl {

	@GetMapping("/secure")
	public String secure(Principal principal) {

		return "redirect:/admin/guru";
	}

}
