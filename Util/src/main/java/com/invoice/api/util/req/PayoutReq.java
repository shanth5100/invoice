package com.invoice.api.util.req;

import java.util.Date;

public class PayoutReq {

	private Long id;
	private Double basicPay;
	private Double grossPay;
	private Double netPay;
	private Date genratedDate;
	
	private Double foodAllowences;
	private Double medicalAllowences;
	private Double houseAllowences;
	private Double otherAllowences;
	private Double overtime;
	
	private Double nationalInsurence;
	private Double lossOfPay;
	private Double loanPayment;
	private Double otherPayments;
	
	
	public Double getBasicPay() {
		return basicPay;
	}
	public Double getGrossPay() {
		return grossPay;
	}
	public Double getNetPay() {
		return netPay;
	}
	public Double getFoodAllowences() {
		return foodAllowences;
	}
	public Double getMedicalAllowences() {
		return medicalAllowences;
	}
	public Double getHouseAllowences() {
		return houseAllowences;
	}
	public Double getOtherAllowences() {
		return otherAllowences;
	}
	public Double getOvertime() {
		return overtime;
	}
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
	public Date getGenratedDate() {
		return genratedDate;
	}
	public void setBasicPay(Double basicPay) {
		this.basicPay = basicPay;
	}
	public void setGrossPay(Double grossPay) {
		this.grossPay = grossPay;
	}
	public void setNetPay(Double netPay) {
		this.netPay = netPay;
	}
	public void setFoodAllowences(Double foodAllowences) {
		this.foodAllowences = foodAllowences;
	}
	public void setMedicalAllowences(Double medicalAllowences) {
		this.medicalAllowences = medicalAllowences;
	}
	public void setHouseAllowences(Double houseAllowences) {
		this.houseAllowences = houseAllowences;
	}
	public void setOtherAllowences(Double otherAllowences) {
		this.otherAllowences = otherAllowences;
	}
	public void setOvertime(Double overtime) {
		this.overtime = overtime;
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
	public void setGenratedDate(Date genratedDate) {
		this.genratedDate = genratedDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
