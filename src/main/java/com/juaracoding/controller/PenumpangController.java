package com.juaracoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.model.PenumpangModel;
import com.juaracoding.repostory.PenumpangRepository;

@RestController
@RequestMapping("/penumpang")
public class PenumpangController {
	
	@Autowired
	PenumpangRepository penumpangRepository;
	
	@GetMapping("/daftar")
	private void daftar() {

	}
	
	@GetMapping("/loginpenumpang")
	private void loginPenumpang() {

	}
}
