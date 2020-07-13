package com.invoice.api.util.dao.beans.field;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Email extends Name{

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
