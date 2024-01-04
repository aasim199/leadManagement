package com.leadmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leadmanagement.entity.Lead;
import com.leadmanagement.exception.CustomException;
import com.leadmanagement.service.ErrorResponse;
import com.leadmanagement.service.LeadService;
import com.leadmanagement.service.LeadServiceImpl;
import com.leadmanagement.service.SucessResponse;

@RestController
@RequestMapping("/api/leads")
@Component
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public ResponseEntity<Object> createLead(@RequestBody Lead lead) {
        try {
            Lead createdLead = leadService.createLead(lead);
            SucessResponse sucessResponse = new SucessResponse("success", "Created Leads Successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(sucessResponse);
        } catch (CustomException e) {

            ErrorResponse errorResponse = new ErrorResponse("E10010", List.of(e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    
    @GetMapping
    public ResponseEntity<Object> getLead(@RequestParam String mobileNo) {
        try {
            List<Lead> leadList = leadService.getLead(mobileNo);
            
            SucessResponse sucessResponse = new SucessResponse("success", leadList);
            return ResponseEntity.status(HttpStatus.CREATED).body(sucessResponse);
        } catch (CustomException e) {

            ErrorResponse errorResponse = new ErrorResponse("E10010", List.of(e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
