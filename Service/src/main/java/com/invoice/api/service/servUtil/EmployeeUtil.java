package com.invoice.api.service.servUtil;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.invoice.api.util.dao.beans.Employee;
import com.invoice.api.util.repo.EmployeeDao;

public class EmployeeUtil {
	@Autowired
	protected EmployeeDao empDao;
	
	public Employee empById(Long eid){
		Optional<Employee> emp = empDao.findById(eid);
		if (emp.isPresent()) {
			return emp.get();
		}
		return null;
	}
}
