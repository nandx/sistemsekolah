package com.sistem.sekolah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCtrl {

	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}
