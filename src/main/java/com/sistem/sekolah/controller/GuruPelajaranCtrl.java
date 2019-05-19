package com.sistem.sekolah.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.sistem.sekolah.entity.Guru;
import com.sistem.sekolah.repository.PelajaranRepository;
import com.sistem.sekolah.security.UserPrincipal;
import com.sistem.sekolah.service.AdminGuruService;

@Controller
public class GuruPelajaranCtrl {

	@Autowired
	AdminGuruService adminGuruService;
	@Autowired
	PelajaranRepository pelajaranRepository;
	
	@GetMapping("/guru/pelajaran")
	public String list(Model model, Principal principal) {
		Authentication auth = (UsernamePasswordAuthenticationToken) principal;
		UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
		Integer id = userPrincipal.getAppUser().getGuru().getId();
		Guru g = adminGuruService.getGuru(id);
		System.err.println(g.getNamaGuru());
		model.addAttribute("dataGuru", pelajaranRepository.findByGuru(g));
		return "/guru/pelajaran/guru_pelajaran_list";
	}

}
