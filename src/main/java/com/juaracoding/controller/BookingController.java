package com.juaracoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.model.PenumpangModel;
import com.juaracoding.repostory.BookingRepository;

@Controller
@RequestMapping("/bookingsystem")
public class BookingController {

	@Autowired
	BookingRepository bookingRepository;
	
	@GetMapping("/cancel")
	private String cancelBooking() {
		return "formcancel";
	}

	@GetMapping("/hapusbooking")
	private String dataLogin(Model model, @RequestParam(name = "id", defaultValue = "")long id) {
		bookingRepository.deleteById(id);
		return "cancelmessage";
	}
}
