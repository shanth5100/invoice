package com.invoice.api.util.service;

import com.invoice.api.util.req.EmployeeReq;
import com.invoice.api.util.resp.EmployeeResponse;

public interface UtilEmpService {
	EmployeeResponse saveEmployee(EmployeeReq empReq);
}
