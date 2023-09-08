package com.sunBase.assignment.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunBase.assignment.entity.LoanData;
import com.sunBase.assignment.exceptions.LoanException;
import com.sunBase.assignment.repo.AuditTrailRepo;
import com.sunBase.assignment.repo.LoanDataRepo;
import com.sunBase.assignment.service.LoanDataService;

@RestController
public class LoanDataController {

	@Autowired
	private LoanDataRepo loanDataRepo;
	
    @Autowired
	private LoanDataService loanDataService;
    
    @Autowired
    private AuditTrailRepo auditTrailRepo;
	
	@PostMapping("/addLoanData")
	public String createLoanData(@RequestBody LoanData loanData){
		
		loanDataRepo.save(loanData);
		
		return "DATA ADDEED SUCCESSFULLY";
		
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<LoanData> createCustomer(@RequestBody LoanData loanData) {
		
		LoanData createLoan = loanDataService.registerNewCustomer(loanData);
		
		return new ResponseEntity<LoanData>(createLoan,HttpStatus.CREATED);
	}
	
	@GetMapping("/getLoanData")
	public ResponseEntity<?> getLoanData(){
		return ResponseEntity.ok("this is loanData");
	}

	@GetMapping("/getAllLoanData")
	public List<LoanData> getAllData(){
		List<LoanData> allLoanData= loanDataRepo.findAll();
		return allLoanData;
	}
	
	//GEt Customer by ID
		@GetMapping("/customer/{id}")
	public ResponseEntity<LoanData> getCustomer(@PathVariable("id") Integer id) {
			
			LoanData loanGet = loanDataService.getLoanById(id);
			
			return new ResponseEntity<LoanData>(loanGet,HttpStatus.FOUND);
			
		}
		
		// Update Customer by Id

		@PutMapping("/update/{id}")
		public ResponseEntity<LoanData> updateLoan(@RequestBody LoanData updateLoan , @PathVariable("id") Integer id) throws LoanException{
			LoanData currentLoan = loanDataService.getLoanById(id);
			
//			LocalDateTime timeStamp = LocalDateTime.now();
//			auditTrailRepo.save(timeStamp);
			System.out.println(currentLoan);
//			auditTrailRepo.save(currentLoan);
//			System.out.println(timeStamp);
			
			
			
			LoanData updateLoans = loanDataService.updateLoanById(id, updateLoan);
			
			return new ResponseEntity<LoanData>(updateLoans,HttpStatus.ACCEPTED);
			
		}
		
		//Delete customer by id
		
		@DeleteMapping("/deleteCustomer/{id}")
		public ResponseEntity<LoanData> deleteCustomer(@PathVariable("id") Integer id) {
			
			LoanData loanDel = loanDataService.deleteLoanById(id);
			
			return new ResponseEntity<LoanData>(loanDel,HttpStatus.MOVED_PERMANENTLY);
			
		}
}
