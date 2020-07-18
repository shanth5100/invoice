package com.invoice.api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.api.util.req.PayoutReq;
import com.invoice.api.util.resp.PayoutResponse;
import com.invoice.api.util.service.UtilPayoutService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/invoice/employee/{empId}/payslip")
public class PayoutController {

	@Autowired
	private UtilPayoutService utilPayoutService;
	
	@PostMapping
	private ResponseEntity<?> savePayout(@PathVariable Long empId, @Valid @RequestBody PayoutReq payoutReq){
		PayoutResponse payoutResponse = utilPayoutService.savePayout(empId, payoutReq);
		if (payoutResponse != null) {
			return ResponseEntity.created(URI.create("")).body(payoutResponse);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(payoutResponse);
	}
	
	@GetMapping
	private ResponseEntity<?> payoutList(@PathVariable Long empId){
		List<PayoutResponse> payoutResponse = utilPayoutService.payoutList(empId);
		return ResponseEntity.ok().body(payoutResponse);
	}
	
	@PutMapping("/{payId}")
	private ResponseEntity<?> getPayout(@PathVariable Long empId, @PathVariable Long payId){
		return null;
	}
	
	
}
