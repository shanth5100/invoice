package com.invoice.api.util.req;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.invoice.api.util.dao.beans.constnt.Roles;

public class UserReq {

	private Long id;
	private String name;
	private String email;
	private String password;
//	private EnumSet<Roles> roles;
	@Enumerated(EnumType.ORDINAL)
	private Roles role;
	
	/*
	 * public EnumSet<Roles> getRoles() { return roles; } public void
	 * setRoles(EnumSet<Roles> roles) { this.roles = roles; }
	 */
	
	public Long getId() {
		return id;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}
