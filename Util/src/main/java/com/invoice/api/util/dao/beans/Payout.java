package com.invoice.api.util.dao.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.invoice.api.util.dao.beans.field.IdGenarate;

@Entity
@Table(name = "payout")
public class Payout extends IdGenarate{

	/*
	 * @OneToOne(cascade = CascadeType.ALL) private Allowences allowences;
	 */

	/*
	 * public void setAllowences(Allowences allowences) { this.allowences =
	 * allowences; }public Allowences getAllowences() { return allowences; }
	 */
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	private Employee employeePay;
	
	private Double basicPay;
	private Double grossPay;
	private Double netPay;
	
	private Double foodAllowences;
	private Double medicalAllowences;
	private Double houseAllowences;
	private Double otherAllowences;
	private Double overtime;
	
	private Double nationalInsurence;
	private Double lossOfPay;
	private Double loanPayment;
	private Double otherPayments;
	
	private Date genratedDate;
	
	public Date getGenratedDate() {
		return genratedDate;
	}
	public void setGenratedDate(Date genratedDate) {
		this.genratedDate = genratedDate;
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
	public Double getBasicPay() {
		return basicPay;
	}
	public Double getGrossPay() {
		return grossPay;
	}
	public Double getNetPay() {
		return netPay;
	}
	
	public Employee getEmployee() {
		return employeePay;
	}
	
	public void setEmployee(Employee employee) {
		this.employeePay = employee;
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
	@Override
	public String toString() {
		return "Payout [employee=" + employeePay + ", basicPay=" + basicPay + ", grossPay=" + grossPay + ", netPay="
				+ netPay + ", foodAllowences=" + foodAllowences + ", medicalAllowences=" + medicalAllowences
				+ ", houseAllowences=" + houseAllowences + ", otherAllowences=" + otherAllowences + ", overtime="
				+ overtime + ", nationalInsurence=" + nationalInsurence + ", lossOfPay=" + lossOfPay + ", loanPayment="
				+ loanPayment + ", otherPayments=" + otherPayments + ", genratedDate=" + genratedDate + "]";
	}
	
}
