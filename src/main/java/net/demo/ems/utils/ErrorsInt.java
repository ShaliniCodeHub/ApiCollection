package net.demo.ems.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorsInt {

	private String errorCode;
	private String description;
	private Object fields;

	public ErrorsInt() {

	}

	public ErrorsInt(String errorCode, String description, Object fields) {
		super();
		this.errorCode = errorCode;
		this.description = description;
		this.fields = fields;
	}
	
	public ErrorsInt(String errorCode, String description) {
		super();
		this.errorCode = errorCode;
		this.description = description;
		this.fields = null;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getFields() {
		return fields;
	}

	public void setFields(Object fields) {
		this.fields = fields;
	}
}
