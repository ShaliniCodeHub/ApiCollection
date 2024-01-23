package net.demo.ems.exception;

import java.io.Serializable;

import net.demo.ems.utils.ServiceResponse;

public class CustomException extends RuntimeException implements Serializable{ 

	
  private static final long serialVersionUID = 1L;
	
	private final String contextName;
	private final String businessExceptionMessage;
	private final String exceptionCode;
	private final Object responseObj;
	private final String externalErrorCode;
	private final String externalResponseCode;
	
	
	public CustomException(String context_name,
			String businessExceptionMessage, String exceptionCode,
			Object responseObj) {
		super(businessExceptionMessage);
		this.contextName = context_name;
		this.businessExceptionMessage = businessExceptionMessage;
		this.exceptionCode = exceptionCode;
		this.responseObj = responseObj;
		this.externalErrorCode = exceptionCode;
		this.externalResponseCode = exceptionCode;
	}
	
	public CustomException(ServiceResponse exposedResponse) {
		this.contextName = null;
	    this.businessExceptionMessage = null;
	    this.exceptionCode = null;
	    this.responseObj = exposedResponse;
	    this.externalErrorCode=null;
	    this.externalResponseCode=null;
	  }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContextName() {
		return contextName;
	}

	public String getBusinessExceptionMessage() {
		return businessExceptionMessage;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public Object getResponseObj() {
		return responseObj;
	}

	public String getExternalErrorCode() {
		return externalErrorCode;
	}

	public String getExternalResponseCode() {
		return externalResponseCode;
	}

	@Override
	public String toString() {
		return "CustomException [contextName=" + contextName + ", businessExceptionMessage=" + businessExceptionMessage
				+ ", exceptionCode=" + exceptionCode + ", responseObj=" + responseObj + ", externalErrorCode="
				+ externalErrorCode + ", externalResponseCode=" + externalResponseCode + "]";
	}
	
}
