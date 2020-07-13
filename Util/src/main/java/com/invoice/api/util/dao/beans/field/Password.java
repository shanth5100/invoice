package com.invoice.api.util.dao.beans.field;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Password extends Email{

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
