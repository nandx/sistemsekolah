package com.sistem.sekolah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestingCtrl {

	@GetMapping("/testing")
	public String testing() {
		return "/testing/tables";
	}

}
