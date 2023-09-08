package com.sunBase.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunBase.assignment.entity.AuditTrail;
import com.sunBase.assignment.repo.AuditTrailRepo;


	@Service
	public class AuditTrailServiceImpl implements AuditTrailService {
		
	    @Autowired
	    private AuditTrailRepo auditTrailRepo;

	    public List<AuditTrail> getAuditTrailsByParentId(int id) {
	        return auditTrailRepo.findById(id);
	    }
	}

