package com.invoice.api.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
	public List<EmployeeResponse> employeeList() {
		
		List<Employee> empList = empDao.findAll();
		List<EmployeeResponse> list = convertToEMpResp(empList);
		
		return list;
	}
	
	@Override
	public EmployeeResponse saveEmployee(EmployeeReq empReq) {

		Employee validReq = validateRequest(empReq);
		Employee response = empDao.save(validReq);
		EmployeeResponse validResponse = validResponse(response);
		
		return validResponse;
	}


	@Override
	public EmployeeResponse updateEmployee(Long id, EmployeeReq empReq) {
		Optional<Employee> empById = empDao.findById(id);
		if (empById.isPresent()) {
			Employee updateEmp = empById.get();

			updateEmp.setEmp_id(empReq.getEmp_id());
			updateEmp.setName(empReq.getName());
			updateEmp.setEmail(empReq.getDepartment());
			updateEmp.setSalary(empReq.getSalary());
			updateEmp.setJoinDate(empReq.getJoinDate());
			updateEmp.setOrganisation(empReq.getOrganisation());
			updateEmp.setDepartment(empReq.getDepartment());
			
			Employee updateEmpResp = empDao.save(updateEmp);
			EmployeeResponse empResp = validResponse(updateEmpResp);
			return empResp;
		}
		return null;
	}

	private List<EmployeeResponse> convertToEMpResp(List<Employee> empList) {
		List<EmployeeResponse> list = new LinkedList<EmployeeResponse>();
		for (Employee employee : empList) {
			EmployeeResponse emp = validResponse(employee);
			list.add(emp);
		}
		
		return list;
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
