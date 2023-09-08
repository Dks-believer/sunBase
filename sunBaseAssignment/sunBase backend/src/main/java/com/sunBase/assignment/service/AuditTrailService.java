package com.sunBase.assignment.service;

import java.util.List;

import com.sunBase.assignment.entity.AuditTrail;

public interface AuditTrailService {

	public List<AuditTrail> getAuditTrailsByParentId(int id);
}
