package com.juaracoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.model.BookingModel;
import com.juaracoding.model.BusModel;
import com.juaracoding.model.CustomGetKeberangkatan;
import com.juaracoding.model.PenumpangModel;
import com.juaracoding.repostory.BookingRepository;
import com.juaracoding.repostory.BusRepository;
import com.juaracoding.repostory.KeberangkatanRepository;
import com.juaracoding.repostory.PenumpangRepository;

@RestController
@RequestMapping("/busbookingsystem")
public class BusController {

	@Autowired
	BusRepository busRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	PenumpangRepository penumpangRepository;
	
	@Autowired
	KeberangkatanRepository keberangkatanRepository;
	
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
	
//	@GetMapping("/findKeberangkatan")
//	private List<CustomGetKeberangkatan> findByKeberangkatan(
//			@RequestParam("terminal") String terminal,
//			@RequestParam("tanggal") String tanggal) {
//		return keberangkatanRepository.getKeberangkatan(terminal, tanggal);
//	}
//	
	
	@PostMapping("/booking")
	private ResponseEntity<String> booking(@RequestBody BookingModel booking){
		bookingRepository.save(booking);
		return ResponseEntity.status(HttpStatus.CREATED).body("Pemesanan bus berhasil");
	}
	
	@DeleteMapping("/cancel")
	private String deleteBooking(@RequestParam("id")long id) {
		bookingRepository.deleteById(id);
		return "Pemesanan dengan nomor id "+id+" telah dibatalkan";
	}
}
