package com.invoice.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		if (employeeResponse != null) {
			return ResponseEntity.created(URI.create("")).body(employeeResponse);
		}
		return ResponseEntity.status(406).body("Unable to process your request");		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeReq empReq) {
		EmployeeResponse employeeResponse = utilEmpService.updateEmployee(id, empReq);
		if (employeeResponse != null) {
			return ResponseEntity.ok().body(employeeResponse);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeResponse);		
	}
	
	@GetMapping
	public ResponseEntity<?> employeeList() {
		List<EmployeeResponse> employeeList = utilEmpService.employeeList();
		return ResponseEntity.ok().body(employeeList);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> employeeById(@PathVariable Long id) {
		EmployeeResponse employee = utilEmpService.employeeById(id);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee not found by "+id);
		}
		return ResponseEntity.ok().body(employee);		
	}
	
}
