package com.sistem.sekolah.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCtrl {

	@RequestMapping("/")
	public String index() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(Principal principal) {
		if (principal != null)
			return "redirect:/secure";
		return "login";
	}

}
