package com.invoice.api.util.dao.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.invoice.api.util.dao.beans.constnt.Roles;
import com.invoice.api.util.dao.beans.field.Password;

@Entity
@Table(name = "user")
public class User extends Password{

	/*
	 * private EnumSet<Roles> roles;
	 * 
	 * public EnumSet<Roles> getRoles() { return roles; }
	 * 
	 * public void setRoles(EnumSet<Roles> roles) { this.roles = roles; }
	 */
	
	@Enumerated(EnumType.ORDINAL) 
	private Roles role;

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
}
