package com.sunBase.assignment.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sunBase.assignment.entity.AuditTrail;
import com.sunBase.assignment.entity.LoanData;

public interface AuditTrailRepo extends MongoRepository<AuditTrail,Integer>{

	List<AuditTrail> findById(int id);

	void save(LocalDateTime timeStamp);

	AuditTrail save(AuditTrail currentLoan);
	
	
}
