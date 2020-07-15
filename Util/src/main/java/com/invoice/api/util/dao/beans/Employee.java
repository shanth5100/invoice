package com.invoice.api.util.dao.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.invoice.api.util.dao.beans.constnt.Organisation;
import com.invoice.api.util.dao.beans.field.Salary;

@Entity
@Table(name = "employee")
public class Employee extends Salary {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	 * 
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 */	
	
	@Enumerated(EnumType.STRING)
	private Organisation organisation;

	@Column(updatable = false)
	private Date joinDate;
	
	@JsonIgnore 
	@OneToMany(cascade=CascadeType.ALL, mappedBy="employee", fetch = FetchType.EAGER)
	private Set<AccountDetails> accDetails;
	
	@JsonIgnore 
	@OneToMany(cascade=CascadeType.ALL, mappedBy="employeePay", fetch = FetchType.EAGER)
	private Set<Payout> payout;

	@NotBlank
	@Column(updatable = false)
	private String emp_id;
	private String department;

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [organisation=" + organisation + ", joinDate=" + joinDate + ", accDetails=" + accDetails
				+ ", emp_id=" + emp_id + ", department=" + department + "]";
	}

}
