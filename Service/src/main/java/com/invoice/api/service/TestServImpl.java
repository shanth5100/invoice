package com.invoice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.api.util.repo.UtilTestRepo;
import com.invoice.api.util.service.UtilTestService;

@Service
public class TestServImpl implements UtilTestService{

	@Autowired
	UtilTestRepo utilTestRepo;
	@Override
	public String getMessage() {
		return utilTestRepo.getMessage();
//		return "api.service.TestServImpl";
	}

}
