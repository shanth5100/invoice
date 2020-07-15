package com.invoice.api.util.dao.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	 * 
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
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
