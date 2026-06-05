package com.erp.service.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/Message")
	public String message() {
		return "Saifuddin";
	}
}
