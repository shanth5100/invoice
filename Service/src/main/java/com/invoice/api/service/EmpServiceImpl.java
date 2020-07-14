package com.invoice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.api.util.dao.beans.Employee;
import com.invoice.api.util.dao.beans.constnt.Organisation;
import com.invoice.api.util.repo.EmployeeDao;
import com.invoice.api.util.req.EmployeeReq;
import com.invoice.api.util.resp.EmployeeResponse;
import com.invoice.api.util.service.UtilEmpService;

@Service
public class EmpServiceImpl implements UtilEmpService{

	@Autowired
	EmployeeDao empDao;
	@Override
	public EmployeeResponse saveEmployee(EmployeeReq empReq) {
		
//		EmployeeReq validReq = validateRequest(empReq);
		Employee validReq = validateRequest(empReq);
		Employee response = empDao.save(validReq);
		EmployeeResponse validResponse = validResponse(response);
		return validResponse;
	}

	private EmployeeResponse validResponse(Employee response) {
		EmployeeResponse validResponse = new EmployeeResponse();
		
		validResponse.setId(response.getId());
		validResponse.setName(response.getName());
		validResponse.setEmail(response.getEmail());
		validResponse.setDepartment(response.getDepartment());
		validResponse.setJoinDate(response.getJoinDate());
		validResponse.setOrganisation(response.getOrganisation());
		validResponse.setSalary(response.getSalary());
		
		return validResponse;
	}

	private Employee validateRequest(EmployeeReq empReq) {
		Employee validReq = new Employee();
		
		validReq.setName(empReq.getName());
		validReq.setEmail(empReq.getEmail());
		validReq.setEmp_id(empReq.getEmp_id());
		validReq.setJoinDate(empReq.getJoinDate());
		validReq.setDepartment(empReq.getDepartment());
		validReq.setSalary(empReq.getSalary());
		
		if(Organisation.Geek_space.equals(empReq.getOrganisation())) {
			validReq.setOrganisation(Organisation.Geek_space);
		} else if(Organisation.One24Apps.equals(empReq.getOrganisation())) {
			validReq.setOrganisation(Organisation.One24Apps);
		} else {
			validReq.setOrganisation(Organisation.Qwiqapp);
		}
		
		return validReq;
	}

}
