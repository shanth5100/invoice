package com.invoice.api.util.req;

import javax.validation.constraints.NotBlank;

public class AccountDetailsReq {
	private Long id;
	@NotBlank
	private String bankName;
	@NotBlank
	private String accNumber;
	@NotBlank
	private String ifsc;
	
	public Long getId() {
		return id;
	}
	public String getBankName() {
		return bankName;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
}
