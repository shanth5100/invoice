package com.invoice.api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.api.util.dao.beans.User;
import com.invoice.api.util.dao.beans.constnt.AppConstants;
import com.invoice.api.util.req.UserReq;
import com.invoice.api.util.service.UtilUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private AppConstants appConstants;
	
	@Autowired
	private UtilUserService userService;

	@PostMapping("invoice/user/")
	public ResponseEntity<?> saveUser(@Valid @RequestBody UserReq userReq) {
		appConstants = new AppConstants();
		if (userReq.getName() != null) {
			UserReq userResp = null;
			try {
				userResp = userService.saveUser(userReq);
			} catch (Exception e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
			if (userResp != null) {
				return ResponseEntity.created(URI.create("")).body(appConstants.USER_CREATED);	
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.badRequest().body(appConstants.NO_USERNAME);
	}
	
	@GetMapping("/invoice/user")
	private ResponseEntity<?> getUser() {		
		List<User> users = userService.getUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
}
