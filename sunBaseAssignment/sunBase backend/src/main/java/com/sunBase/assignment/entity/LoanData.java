package com.sunBase.assignment.entity;

import java.util.ArrayList;
import java.util.List;

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
@Document(collection="LoanData")
public class LoanData {

	@Id
	private int id;
	private String customerName;
	private String gurrantorName;
	private String status;
	
	
//  @OneToMany(mappedBy = "EmbifiApplication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    @DBRef
    private List<AuditTrail> auditTrails = new ArrayList<>();
    
   
	
}
