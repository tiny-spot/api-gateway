package com.tiny.spot.gateway;

import java.io.Serializable;

public abstract class BaseResponse implements Serializable {

	private static final long serialVersionUID = 4373396524302180959L;

	private Boolean success;
	private String resultCode;
	private String message;
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
