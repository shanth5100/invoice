package com.invoice.api.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.api.service.servUtil.EmployeeUtil;
import com.invoice.api.util.dao.beans.AccountDetails;
import com.invoice.api.util.dao.beans.Employee;
import com.invoice.api.util.repo.AccountDetailsDao;
import com.invoice.api.util.req.AccountDetailsReq;
import com.invoice.api.util.resp.AccountDetailsResp;
import com.invoice.api.util.service.UtilAccountDetailsService;

@Service
public class AccountDetailsServiceImpl extends EmployeeUtil implements UtilAccountDetailsService {

	@Autowired
	private AccountDetailsDao accDetailsDao;
	
	@Override
	public AccountDetailsResp saveAccDetails(Long eid, @Valid AccountDetailsReq accDetaReq) {
		Employee employee = empById(eid);
				 
		if (employee != null) {
			AccountDetails accountDetails = convertToAccountDeatils(accDetaReq, employee);
			AccountDetails accountDetailsResp = accDetailsDao.save(accountDetails);
			AccountDetailsResp resp = convertToResp(accountDetailsResp);
			return resp;
		}
		return null;
	}

	@Override
	public AccountDetailsResp updateAccDetails(Long eid, Long aid, @Valid AccountDetailsReq accDetaReq) {
		Employee employee = empById(eid);
		if (employee != null) {
			Optional<AccountDetails> accDetailsOpt = accDetailsDao.findById(aid);
			if(accDetailsOpt.isPresent()) {
				AccountDetails acc = accDetailsOpt.get();
				acc.setAccNumber(accDetaReq.getAccNumber());
				acc.setIfsc(accDetaReq.getIfsc());
				acc.setName(accDetaReq.getBankName());
				
				AccountDetails accdetails = accDetailsDao.save(acc);
				AccountDetailsResp resp = convertToResp(accdetails);
				return resp;
			}
			return null;
		}
		return null;
	}

	@Override
	public List<AccountDetailsResp> getAccDetails(Long eid) {
		Employee employee = empById(eid);
		if (employee != null) {
			List<AccountDetailsResp> respList = new LinkedList<>();
			List<AccountDetails> accountDetailsList = accDetailsDao.findAll();
			for (AccountDetails accountDetails : accountDetailsList) {
				AccountDetailsResp resp = convertToResp(accountDetails);
				respList.add(resp);
			}
			return respList;
		}
		return null;
	}
	
	private AccountDetailsResp convertToResp(AccountDetails accountDetailsResp) {
		AccountDetailsResp resp = new AccountDetailsResp();
		resp.setId(accountDetailsResp.getId());
		resp.setAccNumber(accountDetailsResp.getAccNumber());
		resp.setBankName(accountDetailsResp.getName());
		resp.setIfsc(accountDetailsResp.getIfsc());
		return resp;
	}

	private AccountDetails convertToAccountDeatils(@Valid AccountDetailsReq accDetaReq, Employee employee) {
		System.out.println("convertToAccountDeatils");
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setEmployee(employee);
		accountDetails.setAccNumber(accDetaReq.getAccNumber());
		accountDetails.setName(accDetaReq.getBankName());
		accountDetails.setIfsc(accDetaReq.getIfsc());
		return accountDetails;
	}

}
