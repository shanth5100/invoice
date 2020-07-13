package com.invoice.api.util.dao.beans.field;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Name extends IdGenarate{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
