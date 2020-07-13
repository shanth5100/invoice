package com.invoice.api.dao;

import org.springframework.stereotype.Repository;

import com.invoice.api.util.repo.UtilTestRepo;

@Repository
public class DaoTestImpl implements UtilTestRepo{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "DaoTestImpl.getmessage()";
	}

}
