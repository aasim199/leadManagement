package com.leadmanagement.service;

import java.util.List;

public class ErrorResponse {

	private String code;
    private List<String> messages;
    
    public ErrorResponse() {
    }
    
	public ErrorResponse(String code, List<String> messages) {
		this.code = code;
		this.messages = messages;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
    
    
}
