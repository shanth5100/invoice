package com.invoice.api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.api.util.req.AccountDetailsReq;
import com.invoice.api.util.resp.AccountDetailsResp;
import com.invoice.api.util.service.UtilAccountDetailsService;


@CrossOrigin
@RestController
@RequestMapping("/invoice/employee/{eid}/accontDetails")
public class AccountDetailsController{

	@Autowired
	private UtilAccountDetailsService accDetailsServ;
	
	@PostMapping
	private ResponseEntity<?> saveAccDetails(@PathVariable Long eid, @Valid @RequestBody AccountDetailsReq accDetaReq){
		AccountDetailsResp resp = accDetailsServ.saveAccDetails(eid, accDetaReq);
		if (resp != null ) {
			return ResponseEntity.created(URI.create("")).body(resp);
		}
		return ResponseEntity.badRequest().body("Employee not found by "+eid);
	}
	
	@PutMapping("/{aid}")
	private ResponseEntity<?> updateAccDetails(@PathVariable Long eid, @PathVariable Long aid, @Valid @RequestBody AccountDetailsReq accDetaReq){
		AccountDetailsResp resp = accDetailsServ.updateAccDetails(eid, aid, accDetaReq);
		if (resp != null ) {
			return ResponseEntity.ok().body(resp);
		}
		return ResponseEntity.badRequest().body("Employee not found by "+eid);
	}
	
	@GetMapping
	private ResponseEntity<?> getAccDetails(@PathVariable Long eid){
		List<AccountDetailsResp> resp = accDetailsServ.getAccDetails(eid);
		return ResponseEntity.ok().body(resp);
	}
}
