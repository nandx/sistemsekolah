package com.sistem.sekolah.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistem.sekolah.entity.Guru;
import com.sistem.sekolah.service.AdminGuruService;

@Controller
public class MasterGuruCtrl {

	@Autowired
	private AdminGuruService adminGuruService;

	@GetMapping("/admin/guru")
	public String list(Model model, Principal principal) throws ClientProtocolException, IOException {
		// ambil data dari url
		String stringurl = "http://localhost:8080/rest/guru/list";
		HttpGet request = new HttpGet(stringurl);
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(request);
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		// simpan data dari url sebagai string
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = bufReader.readLine()) != null) {
			builder.append(line);
			builder.append(System.lineSeparator());
		}
		bufReader.close();

		// convert string to json
		if (builder.toString().trim().length() > 0) {
			JSONArray jsonArray = new JSONArray(builder.toString());
			ObjectMapper mapper = new ObjectMapper();
			List<Guru> listguru = new ArrayList<Guru>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject json = jsonArray.getJSONObject(i);
				//convert json to object guru
				Guru guru = mapper.readValue(json.toString(), Guru.class);
				listguru.add(guru);
			}
			//siap ditampilkan ke view thymeleaf
			model.addAttribute("list_guru", listguru);
		}

//		List<Guru> list = adminGuruService.getList();
//		model.addAttribute("list_guru", list);
		return "/admin/master_guru/master_guru_list";
	}

	@GetMapping("/admin/guru/add")
	public String add(Model model) {
		model.addAttribute("data", new Guru());
		return "/admin/master_guru/master_guru_detail";
	}

	@PostMapping("/admin/guru/add")
	public String addSave(Model model, @ModelAttribute Guru guru) {
		System.out.println(guru.getStatus());
		System.out.println("guru : " + guru.getNamaGuru());
		adminGuruService.save(guru);
		return "redirect:";
	}

	@GetMapping("/admin/guru/edit")
	public String edit(Model model, @RequestParam("idGuru") Integer paramid) {
		Guru guru = adminGuruService.getGuru(paramid);
		model.addAttribute("data", guru);
		return "/admin/master_guru/master_guru_detail";
	}

}
