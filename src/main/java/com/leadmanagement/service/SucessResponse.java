package com.leadmanagement.service;

import java.util.List;

public class SucessResponse<T> {

	private String status;
	private T data;

	public SucessResponse(String status, T data) {
		this.status = status;
		this.data = data;
	}

	public SucessResponse() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String code) {
		this.status = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
