package com.invoice.api.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.api.util.dao.beans.User;
import com.invoice.api.util.dao.beans.constnt.AppConstants;
import com.invoice.api.util.dao.beans.constnt.Roles;
import com.invoice.api.util.repo.UserDao;
import com.invoice.api.util.req.UserReq;
import com.invoice.api.util.service.UtilUserService;

@Service
public class UserService implements UtilUserService{

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	AppConstants appConstants;
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUsers() {
		List<User> userList = new LinkedList<User>();
		try {
			userList = userDao.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public UserReq saveUser(UserReq userReq) {
		
		User user = setUserRequest(userReq);
		User userResp = null;
		UserReq userReqResp = null;
		try {
			
			userResp = userDao.saveAndFlush(user);
		} catch (Exception e) {
//			logger.error("UserService", e.getStackTrace());
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		if (userResp != null) {
			userReqResp = convertUser(userResp);	
		}
		 
		return userReqResp;
	}
	private UserReq convertUser(User user) {
		UserReq resp = new UserReq();
		resp.setId(user.getId());
		resp.setName(user.getName());
		resp.setEmail(user.getEmail());
		resp.setPassword(user.getPassword());
//		resp.setRoles(user.getRoles());
		resp.setRole(user.getRole());
		
		return resp;
	}
	private User setUserRequest(UserReq userReq) {
		User user = new User();
		appConstants = new AppConstants();
		/*
		 * EnumSet<Roles> roles = null; if
		 * (appConstants.ADMIN.equals(userReq.getName())) { roles =
		 * EnumSet.of(Roles.Admin); } else { roles = EnumSet.of(Roles.User); }
		 * user.setRoles(roles);
		 */
		
		if (appConstants.ADMIN.equals(userReq.getName())) {
			user.setRole(Roles.Admin);
		} else {
			user.setRole(Roles.User);
		}
		
		user.setEmail(userReq.getEmail());
		user.setName(userReq.getName());
		user.setPassword(userReq.getPassword());
		
		return user;
	}
	

}
