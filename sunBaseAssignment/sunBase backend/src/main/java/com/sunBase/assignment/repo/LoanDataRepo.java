package com.sunBase.assignment.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sunBase.assignment.entity.LoanData;

public interface LoanDataRepo extends MongoRepository<LoanData,Integer>{

	
}
