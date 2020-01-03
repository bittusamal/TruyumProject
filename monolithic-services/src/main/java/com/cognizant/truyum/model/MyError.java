package com.cognizant.truyum.model;

import java.util.Date;

public class MyError {

	private String message;
	private String status;
	private Date time;

	public MyError(String message, String status, Date time) {
		super();
		this.message = message;
		this.status = status;
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
