package com.sunBase.assignment.entity;

import java.time.LocalDateTime;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
   

     @Getter
     @Setter
     @AllArgsConstructor
     @NoArgsConstructor
     @Data
	@Document(collection = "audit_trails")
	public class AuditTrail {
	    @Id
	    private int id;

//	    private String oldCustomerName;
//	    private String oldGuarantorName;
//	    private String status;
	    private LocalDateTime timestamp;

	    @DBRef
	    private LoanData loanData;

	    
	
	    
	}

