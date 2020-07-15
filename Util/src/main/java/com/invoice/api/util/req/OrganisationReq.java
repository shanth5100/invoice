package com.invoice.api.util.req;

import com.invoice.api.util.dao.beans.AccountDetails;

public class OrganisationReq {

	private Long id;
	private String organisation;
	private String address1;
	private String address2;
	private AccountDetails account;
	
	public Long getId() {
		return id;
	}
	public String getOrganisation() {
		return organisation;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public AccountDetails getAccount() {
		return account;
	}
	public void setAccount(AccountDetails account) {
		this.account = account;
	}
	
}
