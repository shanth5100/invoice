package com.invoice.api.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.api.util.req.EmployeeReq;

@RestController
public class EmployeeController {

	public ResponseEntity<?> saveUser(@Valid @RequestBody EmployeeReq userReq) {
		return null;		
	}
	
}
