package com.invoice.api.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.api.util.dao.beans.Organisation;
import com.invoice.api.util.repo.OrganisationDao;
import com.invoice.api.util.req.OrganisationReq;
import com.invoice.api.util.resp.OrganisationResp;
import com.invoice.api.util.service.UtilOrganisationService;

@Service
public class OrganisationService implements UtilOrganisationService {

	@Autowired
	OrganisationDao orgDao;
	
	@Override
	public OrganisationResp saveOrg(@Valid OrganisationReq orgReq) {
		Organisation org = convertToOrg(orgReq);
		Organisation orgResp = orgDao.save(org);
		OrganisationResp resp = convertToResp(orgResp);
		return resp;
	}
	
	@Override
	public List<OrganisationResp> getOrg() {
		List<OrganisationResp> respList = new LinkedList<>();
		List<Organisation> list = orgDao.findAll();
		for (Organisation organisation : list) {
			OrganisationResp orgResp = convertToResp(organisation);
			respList.add(orgResp);
		}
		return respList;
	}
	

	@Override
	public OrganisationResp updateOrg(Long id, @Valid OrganisationReq orgReq) {
		Optional<Organisation> orgById = orgDao.findById(id);
		if (orgById.isPresent()) {
			Organisation updateOrg = orgById.get();
			
			updateOrg.setName(orgReq.getOrganisation());
			updateOrg.setAddress1(orgReq.getAddress1());
			updateOrg.setAddress2(orgReq.getAddress2());
			
			Organisation updateOrgResp = orgDao.save(updateOrg);
			
			OrganisationResp resp = convertToResp(updateOrgResp);
			return resp;
		}
		return null;
	}
	
	private OrganisationResp convertToResp(Organisation orgResp) {
		OrganisationResp resp = new OrganisationResp();
		resp.setId(orgResp.getId());
		resp.setOrganisation(orgResp.getName());
		resp.setAddress1(orgResp.getAddress1());
		resp.setAddress2(orgResp.getAddress2());
		return resp;
	}

	private Organisation convertToOrg(OrganisationReq orgReq) {
		
		Organisation org = new Organisation();
		org.setName(orgReq.getOrganisation());
		org.setAddress1(orgReq.getAddress1());
		org.setAddress2(orgReq.getAddress2());
		
		return org;
	}
	
}
