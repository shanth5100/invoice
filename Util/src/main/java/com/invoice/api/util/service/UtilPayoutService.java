package com.invoice.api.util.service;

import java.util.List;

import javax.validation.Valid;

import com.invoice.api.util.req.PayoutReq;
import com.invoice.api.util.resp.PayoutResponse;

public interface UtilPayoutService {

	PayoutResponse savePayout(Long empId, @Valid PayoutReq payoutReq);

	List<PayoutResponse> payoutList(Long empId);

}
