package com.sunBase.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunBase.assignment.entity.LoanData;
import com.sunBase.assignment.exceptions.LoanException;
import com.sunBase.assignment.exceptions.LoanNotFoundException;
import com.sunBase.assignment.repo.LoanDataRepo;

@Service
public class LoanDataServiceImpl implements LoanDataService{

	@Autowired
	private LoanDataRepo loanDataRepo;
	
	@Override
	public LoanData registerNewCustomer(LoanData loanData) {
		return loanDataRepo.save(loanData);
	}

	@Override
	public List<LoanData> getAllLoans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanData getLoanById(int id) {
		// TODO Auto-generated method stub
		 LoanData loanGet = loanDataRepo.findById(id).
	                
				 orElseThrow(() -> new LoanNotFoundException("Loan does not exist or already deleted"));

	        return loanGet;
	}

	
	@Override
	public LoanData updateLoanById(int id, LoanData updatedLoan) {
		 LoanData loanExisting = loanDataRepo.findById(id)
	             .orElseThrow(() -> new LoanNotFoundException("Loan does not exist or already deleted"));

	   
	   // Update the relevant fields of loanToUpdate with data from updatedLoan
		 loanExisting.setCustomerName(updatedLoan.getCustomerName());
		 loanExisting.setGurrantorName(updatedLoan.getGurrantorName());
		 loanExisting.setStatus(updatedLoan.getStatus());
	   
	   
	   // Save the updated loan entity
	   LoanData savedLoan = loanDataRepo.save(loanExisting);

	     return savedLoan;
		}

	@Override
	public LoanData deleteLoanById(int id) {
		 LoanData loanDel = loanDataRepo.findById(id)
	                .orElseThrow(() -> new LoanNotFoundException("Loan does not exist or already deleted"));

	        try {
	            loanDataRepo.delete(loanDel);
	        } catch (Exception e) {
	            // Handle any exceptions that might occur during deletion
	            throw new LoanException("An error occurred while deleting the loan");
	        }

	        return loanDel;
			}

	
	
}
