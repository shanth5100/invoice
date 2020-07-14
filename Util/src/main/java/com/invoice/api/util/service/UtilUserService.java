package com.invoice.api.util.service;

import java.util.List;

import com.invoice.api.util.dao.beans.User;
import com.invoice.api.util.req.UserReq;

public interface UtilUserService {

	UserReq saveUser(UserReq userReq);
	
	List<User> getUsers();
}
