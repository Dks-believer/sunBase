package com.sunBase.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.sunBase.assignment.entity.AuditTrail;
import com.sunBase.assignment.service.AuditTrailServiceImpl;



@RestController

public class AuditTrailController {
   
	@Autowired
    private AuditTrailServiceImpl auditTrailService;

    @GetMapping("/audit/{id}")
    public ResponseEntity<List<AuditTrail>> getAuditTrailsByParentId(@PathVariable int id) {
        List<AuditTrail> auditTrails = auditTrailService.getAuditTrailsByParentId(id);
        return ResponseEntity.ok(auditTrails);
    }
}