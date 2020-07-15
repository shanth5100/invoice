package com.invoice.api.util.dao.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.invoice.api.util.dao.beans.field.Name;

@Entity
@Table(name = "organisation")
public class Organisation extends Name{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String address1;
	private String address2;
	@JsonIgnore
	@OneToOne
	@Cascade(CascadeType.ALL)
	private AccountDetails acc_details;
	
	public Long getId() {
		return id;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public AccountDetails getAcc_details() {
		return acc_details;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public void setAcc_details(AccountDetails acc_details) {
		this.acc_details = acc_details;
	}
		
}
