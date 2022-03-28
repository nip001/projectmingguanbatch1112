package com.juaracoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.model.CustomGetKeberangkatan;
import com.juaracoding.model.KeberangkatanModel;
import com.juaracoding.model.PenumpangModel;
import com.juaracoding.repostory.KeberangkatanRepository;

@Controller
@RequestMapping("/keberangkatan")
public class KeberangkatanController {

	@Autowired
	KeberangkatanRepository keberangkatanRepository;
	

	@GetMapping("/carikeberangkatan")
	private String cariKeberangkatan() {
		return "carikeberangkatan";
	}
	
	@GetMapping("/datakeberangkatan")
	private String dataKeberangkatan(Model model, 
			@RequestParam(name = "tanggal", defaultValue = "")String tanggal,
			@RequestParam(name = "terminal", defaultValue = "")String terminal) {
		List<KeberangkatanModel> keberangkatan = keberangkatanRepository.getKeberangkatan(terminal,tanggal);
		if(!keberangkatan.isEmpty()) {
			model.addAttribute("listKeberangkatan",keberangkatan);
			return "listdetailkeberangkatan";
		}else {
			return "kenihilankeberangkatan";
		}
	}
}
