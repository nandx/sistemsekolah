package com.sistem.sekolah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MasterGuruCtrl {

	@GetMapping("/admin/guru")
	public String list() {
		return "/admin/master_guru/master_guru_list";
	}

}
