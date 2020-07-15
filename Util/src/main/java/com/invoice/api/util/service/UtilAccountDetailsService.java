package com.invoice.api.util.service;

import java.util.List;

import javax.validation.Valid;

import com.invoice.api.util.req.AccountDetailsReq;
import com.invoice.api.util.resp.AccountDetailsResp;

public interface UtilAccountDetailsService {

	AccountDetailsResp saveAccDetails(Long eid, @Valid AccountDetailsReq accDetaReq);

	List<AccountDetailsResp> getAccDetails(Long eid);

	AccountDetailsResp updateAccDetails(Long eid, Long aid, @Valid AccountDetailsReq accDetaReq);

}
