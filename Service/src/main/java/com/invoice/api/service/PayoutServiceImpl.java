package com.invoice.api.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.api.service.servUtil.EmployeeUtil;
import com.invoice.api.util.dao.beans.Employee;
import com.invoice.api.util.dao.beans.Payout;
import com.invoice.api.util.repo.PayoutDao;
import com.invoice.api.util.req.PayoutReq;
import com.invoice.api.util.resp.PayoutResponse;
import com.invoice.api.util.service.UtilPayoutService;

@Service
public class PayoutServiceImpl extends EmployeeUtil implements UtilPayoutService {

	@Autowired
	PayoutDao payoutDao;

	@Override
	public PayoutResponse savePayout(Long empId, @Valid PayoutReq payoutReq) {
		Employee employee = empById(empId);
		if (employee != null) {
			Payout payout = convertToPayout(payoutReq, employee);
			Payout payoutResp = payoutDao.save(payout);
			if (payout != null) {
				PayoutResponse resp = convertToResp(payoutResp);
				return resp;
			}
			return null;
		}
		return null;
	}

	@Override
	public List<PayoutResponse> payoutList(Long empId) {
		Employee employee = empById(empId);
		
		if (employee != null) {
			List<PayoutResponse> list = new LinkedList<>();
			List<Payout> payoutResp = payoutDao.findAll();
			if(!payoutResp.isEmpty()) {
				for (Payout payout : payoutResp) {
					PayoutResponse resp = convertToResp(payout);
					list.add(resp);
				}
			}
			return list;
		}
		
		return null;
	}
	
	private PayoutResponse convertToResp(Payout payout) {
		PayoutResponse payoutResponse = new PayoutResponse();
		
		payoutResponse.setId(payout.getId());
		payoutResponse.setGrossPay(payout.getGrossPay());
		payoutResponse.setBasicPay(payout.getBasicPay());
		payoutResponse.setNetPay(payout.getNetPay());
		payoutResponse.setGenratedDate(payout.getGenratedDate());
		
		payoutResponse.setHouseAllowences(payout.getHouseAllowences());
		payoutResponse.setOvertime(payout.getOvertime());
		payoutResponse.setMedicalAllowences(payout.getMedicalAllowences());
		payoutResponse.setFoodAllowences(payout.getFoodAllowences());
		payoutResponse.setOtherAllowences(payout.getOtherAllowences());
		
		payoutResponse.setLoanPayment(payout.getLoanPayment());
		payoutResponse.setLossOfPay(payout.getLossOfPay());
		payoutResponse.setNationalInsurence(payout.getNationalInsurence());
		payoutResponse.setOtherPayments(payout.getOtherPayments());
		
		return payoutResponse;
	}

	private Payout convertToPayout(@Valid PayoutReq payoutReq, Employee employee) {
		Double grossAmount=0.0, netAmount=0.0;
		Payout payout = new Payout();
		grossAmount = employee.getSalary() + payoutReq.getFoodAllowences() + payoutReq.getHouseAllowences()+
				payoutReq.getMedicalAllowences() + payoutReq.getOtherAllowences() + payoutReq.getOvertime();
		netAmount = grossAmount - (payoutReq.getLoanPayment() + payoutReq.getLossOfPay() + payoutReq.getOtherPayments()+
				payoutReq.getNationalInsurence());
		payout.setEmployee(employee);
		payout.setBasicPay(employee.getSalary());
		payout.setNetPay(netAmount);
		payout.setGrossPay(grossAmount);

		payout.setGenratedDate(new Date());
		
		payout.setFoodAllowences(payoutReq.getFoodAllowences());
		payout.setHouseAllowences(payoutReq.getHouseAllowences());
		payout.setMedicalAllowences(payoutReq.getMedicalAllowences());
		payout.setOvertime(payoutReq.getOvertime());
		payout.setOtherAllowences(payoutReq.getOtherAllowences());
		
		payout.setNationalInsurence(payoutReq.getNationalInsurence());
		payout.setLoanPayment(payoutReq.getLoanPayment());
		payout.setLossOfPay(payoutReq.getLossOfPay());
		payout.setOtherPayments(payoutReq.getOtherPayments());
		
		return payout;
	}
	
}
