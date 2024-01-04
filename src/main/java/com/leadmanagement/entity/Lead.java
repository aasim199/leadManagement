package com.leadmanagement.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lead")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lead {

	@Id
	@Column(name = "lead_id", nullable = false)
    private Integer leadId;
	
	@Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "middle_name", nullable = false)
    private String middleName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;
    
    @JsonProperty("Gender")
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @JsonProperty("DOB")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dob", nullable = false)   
    private Date dob;
    
    @Column(name = "email", nullable = false)
    private String email;
    
	public Integer getLeadId() {
		return leadId;
	}
	public void setLeadId(Integer leadId) {
		this.leadId = leadId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
