package com.leadmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadmanagement.entity.Lead;
import com.leadmanagement.exception.CustomException;
import com.leadmanagement.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService{

	@Autowired
	private LeadRepository leadRepository;

	@Override
	public Lead createLead(Lead lead) throws CustomException {

		// Validation for leadId
		validateLeadId(lead.getLeadId());

		// Validation for firstName
		validateName("First Name", lead.getFirstName());

		// Validation for middleName (optional)
		if (lead.getMiddleName() != null && !lead.getMiddleName().isEmpty()) {
			validateName("Middle Name", lead.getMiddleName());
		}

		// Validation for lastName
		validateName("Last Name", lead.getLastName());

		// Validation for mobileNumber
		validateMobileNumber(lead.getMobileNumber());

		// Validation for gender
		validateGender(lead.getGender());

		// Validation for DOB
		validateDateOfBirth(lead.getDob());

		// Validation for email
		validateEmail(lead.getEmail());

		if (leadRepository.existsByLeadId(lead.getLeadId())) {
			throw new CustomException("Lead Already Exists in the database with the lead id");
		}


		return leadRepository.save(lead);
	}
	
	@Override
	public List<Lead> getLead(String mobileNo) throws CustomException {
		 
		validateMobileNumber(mobileNo);
		
		List<Lead> getLead = leadRepository.findByMobileNumber(mobileNo);
		if(getLead.size() == 0 ) {
			throw new CustomException("No Lead found with the Mobile Number");
		}
		
		return getLead;
	}
	
	private void validateLeadId(Integer leadId) throws CustomException {
        if (leadId == null) {
            throw new CustomException("LeadId is mandatory");
        }
        
    }

    private void validateName(String fieldName, String value) throws CustomException {
        if (value == null || value.trim().isEmpty()) {
            throw new CustomException(fieldName + " is mandatory");
        }

        if (!value.matches("^[a-zA-Z]+$")) {
            throw new CustomException(fieldName + " should strictly contain alphabets with no spaces");
        }
    }

    private void validateMobileNumber(String mobileNumber) throws CustomException {
        if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
            throw new CustomException("MobileNumber is mandatory");
        }

        if (!mobileNumber.matches("^\\d+$") || Integer.parseInt(mobileNumber.substring(0, 1)) <= 5) {
            throw new CustomException("MobileNumber should strictly contain integers, and the first digit should be greater than 5");
        }
    }

    private void validateGender(String gender) throws CustomException {
        if (gender == null || gender.trim().isEmpty()) {
            throw new CustomException("Gender is mandatory");
        }
    }

    private void validateDateOfBirth(Date dob) throws CustomException {
        if (dob == null) {
            throw new CustomException("Date of Birth is mandatory");
        }
    }

    private void validateEmail(String email) throws CustomException {
        if (email == null || email.trim().isEmpty()) {
            throw new CustomException("Email is mandatory");
        }

        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
            throw new CustomException("Invalid email format");
        }
    }

	
}
