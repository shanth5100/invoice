package com.invoice.api.util.service;

import java.util.List;

import javax.validation.Valid;

import com.invoice.api.util.req.OrganisationReq;
import com.invoice.api.util.resp.OrganisationResp;

public interface UtilOrganisationService {
	OrganisationResp saveOrg(@Valid OrganisationReq orgReq);

	List<OrganisationResp> getOrg();

	OrganisationResp updateOrg(Long id, @Valid OrganisationReq orgReq);
}
