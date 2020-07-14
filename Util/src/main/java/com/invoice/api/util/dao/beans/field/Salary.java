package com.invoice.api.util.dao.beans.field;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Salary extends Email{

	private Double salary;

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
