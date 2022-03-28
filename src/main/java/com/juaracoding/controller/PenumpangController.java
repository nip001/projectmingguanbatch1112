package com.juaracoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.model.PenumpangModel;
import com.juaracoding.repostory.PenumpangRepository;

@Controller
@RequestMapping("/penumpang")
public class PenumpangController {
	
	@Autowired
	PenumpangRepository penumpangRepository;
	
	@GetMapping("/daftar")
	private void daftar() {

	}

	@GetMapping("/loginpenumpang")
	private String loginPenumpang() {
		return "formlogin";
	}
	
	@GetMapping("/datalogin")
	private String dataLogin(Model model, @RequestParam(name = "nik", defaultValue = "")String nik) {
		PenumpangModel penumModel = penumpangRepository.findByNik(nik);
		if(penumModel != null) {
			model.addAttribute("penumpang",penumModel);
			return "detailpenumpang";
		}else {
			return "kenihilan";
		}
	}
}
