package com.invoice.api.util.service;

import java.util.List;

import com.invoice.api.util.req.EmployeeReq;
import com.invoice.api.util.resp.EmployeeResponse;

public interface UtilEmpService {
	EmployeeResponse saveEmployee(EmployeeReq empReq);

	List<EmployeeResponse> employeeList();

	EmployeeResponse updateEmployee(Long id, EmployeeReq empReq);

	EmployeeResponse employeeById(Long id);
}
