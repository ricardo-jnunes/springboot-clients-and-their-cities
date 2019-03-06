package com.cities.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	private String message;
	private String detail;

	public ExceptionResponse(HttpStatus status, String detail) {
		this.code = status.value();
		this.message = status.getReasonPhrase();
		this.detail = detail;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
