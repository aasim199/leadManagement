package com.leadmanagement.leadmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.leadmanagement.controller.LeadController;
import com.leadmanagement.entity.Lead;
import com.leadmanagement.exception.CustomException;
import com.leadmanagement.service.ErrorResponse;
import com.leadmanagement.service.LeadService;
import com.leadmanagement.service.SucessResponse;

@ExtendWith(MockitoExtension.class)
class LeadManagementApplicationTests {

	@Mock
	private LeadService leadService;

	@InjectMocks
	private LeadController leadController;

	@Test
	public void testCreateLead_Success() throws CustomException {
		// Arrange
		Lead lead = new Lead();
	    when(leadService.createLead(ArgumentMatchers.any(Lead.class))).thenReturn(lead);

		// Act
		ResponseEntity<Object> responseEntity = leadController.createLead(lead);

		SucessResponse successResponse = (SucessResponse) responseEntity.getBody();
		assertEquals("success", successResponse.getStatus());
		assertEquals("Created Leads Successfully", successResponse.getData());
	}
	
	@Test
    public void testCreateLead_Failure() throws CustomException {
        // Arrange
        Lead lead = new Lead();
        String mobileNo = "";
        String errorMessage = "MobileNumber is mandatory"; 

        when(leadService.createLead(ArgumentMatchers.any(Lead.class))).thenThrow(new CustomException(errorMessage));

        // Act
        ResponseEntity<Object> responseEntity = leadController.createLead(lead);

        // Assert
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        assertEquals("E10010", errorResponse.getCode());
        assertEquals("MobileNumber is mandatory", errorResponse.getMessages().get(0));
    }

    @Test
    public void testGetLead_Success() throws CustomException {
        // Arrange
        String mobileNo = "1234567890";
        List<Lead> leadList = List.of(new Lead());
        when(leadService.getLead(mobileNo)).thenReturn(leadList);

        // Act
        ResponseEntity<Object> responseEntity = leadController.getLead(mobileNo);

        // Assert
        SucessResponse successResponse = (SucessResponse) responseEntity.getBody();
        assertEquals("success", successResponse.getStatus());
        assertEquals(leadList, successResponse.getData());
    }

    @Test
    public void testGetLead_Failure() throws CustomException {
        // Arrange
    	String errorMessage = "No Lead found with the Mobile Number";
        String mobileNo = "1234567890";
        List<Lead> leadList = List.of(new Lead());
        when(leadService.getLead(mobileNo)).thenThrow(new CustomException(errorMessage));

        // Act
        ResponseEntity<Object> responseEntity = leadController.getLead(mobileNo);

        // Assert
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        assertEquals("E10010", errorResponse.getCode());
        assertEquals(errorMessage, errorResponse.getMessages().get(0));
    }
	

}
