package com.invoice.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.api.util.req.EmployeeReq;
import com.invoice.api.util.resp.EmployeeResponse;
import com.invoice.api.util.service.UtilEmpService;

@RestController
@RequestMapping("/invoice/employee")
public class EmployeeController {

	@Autowired
	UtilEmpService utilEmpService;
	
	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody EmployeeReq empReq) {
		EmployeeResponse employeeResponse = utilEmpService.saveEmployee(empReq);
		return ResponseEntity.created(URI.create("")).body(employeeResponse);		
	}
	
}
