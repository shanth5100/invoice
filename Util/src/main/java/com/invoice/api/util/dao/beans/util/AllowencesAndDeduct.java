package com.invoice.api.util.dao.beans.util;


public class AllowencesAndDeduct {
	private Float foodAllowences;
	private Float medicalAllowences;
	private Float houseAllowences;
	private Float otherAllowences;
	private Float overtime;
	private Float nationalInsurence;
	private Float lossOfPay;
	private Float loanPayment;
	private Float otherPayments;
	
	public Float getNationalInsurence() {
		return nationalInsurence;
	}
	public Float getLossOfPay() {
		return lossOfPay;
	}
	public Float getLoanPayment() {
		return loanPayment;
	}
	public Float getOtherPayments() {
		return otherPayments;
	}
	public void setNationalInsurence(Float nationalInsurence) {
		this.nationalInsurence = nationalInsurence;
	}
	public void setLossOfPay(Float lossOfPay) {
		this.lossOfPay = lossOfPay;
	}
	public void setLoanPayment(Float loanPayment) {
		this.loanPayment = loanPayment;
	}
	public void setOtherPayments(Float otherPayments) {
		this.otherPayments = otherPayments;
	}
	public Float getFoodAllowences() {
		return foodAllowences;
	}
	public Float getMedicalAllowences() {
		return medicalAllowences;
	}
	public Float getHouseAllowences() {
		return houseAllowences;
	}
	public Float getOtherAllowences() {
		return otherAllowences;
	}
	public Float getOvertime() {
		return overtime;
	}
	public void setFoodAllowences(Float foodAllowences) {
		this.foodAllowences = foodAllowences;
	}
	public void setMedicalAllowences(Float medicalAllowences) {
		this.medicalAllowences = medicalAllowences;
	}
	public void setHouseAllowences(Float houseAllowences) {
		this.houseAllowences = houseAllowences;
	}
	public void setOtherAllowences(Float otherAllowences) {
		this.otherAllowences = otherAllowences;
	}
	public void setOvertime(Float overtime) {
		this.overtime = overtime;
	}

}
