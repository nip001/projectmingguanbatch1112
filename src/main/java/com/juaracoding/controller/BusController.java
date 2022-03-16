package com.juaracoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.model.BusModel;
import com.juaracoding.model.PenumpangModel;
import com.juaracoding.repostory.BusRepository;
import com.juaracoding.repostory.PenumpangRepository;

@RestController
@RequestMapping("/busbookingsystem")
public class BusController {

	@Autowired
	BusRepository busRepository;
	
	@Autowired
	PenumpangRepository penumpangRepository;
	
	@PostMapping("/insertBus")
	private String saveBus(@RequestBody List<BusModel> model) {
		busRepository.saveAll(model);
		return "Data berhasil ditambahkan";
	}
	
	@PostMapping("/insertPenumpang")
	private String savePenumpang(@RequestBody PenumpangModel model) {
		penumpangRepository.save(model);
		return "Data penumpang berhasil ditambahkan";
	}
	
	@GetMapping("/getPenumpang/{nik}")
	private String getPenumpangByNik(@PathVariable("nik") String nik) {
		PenumpangModel penumpang = penumpangRepository.findByNik(nik);
		if(penumpang != null) {
			return "Penumpang telah terdaftar";
		}else {
			return "Penumpang belum terdaftar, silakan buat akun.";
		}
	}
}
