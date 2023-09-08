package com.sunBase.assignment.service;



import java.util.List;

import com.sunBase.assignment.entity.LoanData;


public interface LoanDataService {

	public LoanData  registerNewCustomer(LoanData loanData);
	
	public List<LoanData> getAllLoans();
	
	public LoanData getLoanById(int id);
	
	public LoanData updateLoanById(int id, LoanData updatedloan);
	
	public LoanData deleteLoanById(int id);
	
	//public List<Loan> getAllLoanApplicationsWithAuditTrails();
}
