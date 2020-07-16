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

import com.invoice.api.util.dao.beans.constnt.AppConstants;
import com.invoice.api.util.req.OrganisationReq;
import com.invoice.api.util.resp.OrganisationResp;
import com.invoice.api.util.service.UtilOrganisationService;

@CrossOrigin
@RestController
@RequestMapping("/invoice/organisation")
public class OrganisationController {
	AppConstants appConst = new AppConstants();
	@Autowired
	UtilOrganisationService orgServ;
	
	@PostMapping
	private ResponseEntity<?> saveOrg(@Valid @RequestBody OrganisationReq orgReq) {
		OrganisationResp resp = orgServ.saveOrg(orgReq);
		if (resp != null) {
			return ResponseEntity.created(URI.create("")).body(resp);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(appConst.MISSING_FIELDS);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<?> updateOrg(@PathVariable Long id, @Valid @RequestBody OrganisationReq orgReq) {
		OrganisationResp resp = orgServ.updateOrg(id, orgReq);
		if (resp != null) {
			
			return ResponseEntity.created(URI.create("")).body(resp);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Org not found by "+id);
	}
	
	@GetMapping
	private ResponseEntity<?> getOrg() {
		List<OrganisationResp> resp = orgServ.getOrg();
		return ResponseEntity.ok().body(resp);

	}
}
