package com.invoice.api.util.dao.beans;

import java.util.Date;
import java.util.EnumSet;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.invoice.api.util.dao.beans.constnt.Organisation;
import com.invoice.api.util.dao.beans.constnt.Roles;
import com.invoice.api.util.dao.beans.field.Salary;

@Entity
@Table(name = "employee")
public class Employee extends Salary{

	private EnumSet<Roles> roles;
	private EnumSet<Organisation> organisation;
	private Date joinDate;
	private Date leftDate;

	public EnumSet<Roles> getRoles() {
		return roles;
	}

	public void setRoles(EnumSet<Roles> roles) {
		this.roles = roles;
	}

	public EnumSet<Organisation> getOrganisation() {
		return organisation;
	}

	public void setOrganisation(EnumSet<Organisation> organisation) {
		this.organisation = organisation;
	}

	public Date getJoin() {
		return joinDate;
	}

	public void setJoin(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLeft() {
		return leftDate;
	}

	public void setLeft(Date leftDate) {
		this.leftDate = leftDate;
	}
	
}
