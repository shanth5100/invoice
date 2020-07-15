package com.invoice.api.util.dao.beans.util;

public class Deduction {
	private Double nationalInsurence;
	private Double lossOfPay;
	private Double loanPayment;
	private Double otherPayments;
	public Double getNationalInsurence() {
		return nationalInsurence;
	}
	public Double getLossOfPay() {
		return lossOfPay;
	}
	public Double getLoanPayment() {
		return loanPayment;
	}
	public Double getOtherPayments() {
		return otherPayments;
	}
	public void setNationalInsurence(Double nationalInsurence) {
		this.nationalInsurence = nationalInsurence;
	}
	public void setLossOfPay(Double lossOfPay) {
		this.lossOfPay = lossOfPay;
	}
	public void setLoanPayment(Double loanPayment) {
		this.loanPayment = loanPayment;
	}
	public void setOtherPayments(Double otherPayments) {
		this.otherPayments = otherPayments;
	}
	
}
