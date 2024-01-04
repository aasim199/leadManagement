package com.leadmanagement.service;

import java.util.List;

import com.leadmanagement.entity.Lead;
import com.leadmanagement.exception.CustomException;

public interface LeadService {

	Lead createLead(Lead lead) throws CustomException;

	List<Lead> getLead(String mobileNo)throws CustomException;
}
