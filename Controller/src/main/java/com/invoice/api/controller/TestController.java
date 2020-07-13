package com.invoice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.api.util.service.UtilTestService;

@RestController
@RequestMapping("/invoice")
public class TestController {

	@Autowired
	private UtilTestService utilTestService;
	
	@GetMapping("/test")
	private ResponseEntity<?> name() {
		return ResponseEntity.ok().body(utilTestService.getMessage());
	}
}
