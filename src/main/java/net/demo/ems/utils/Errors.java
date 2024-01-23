package net.demo.ems.utils;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@jakarta.annotation.Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"errors"})
public class Errors {
	@JsonProperty("errors")
	private List<ErrorsInt> errors;

	public Errors() {

	}

	public Errors(List<ErrorsInt> lstErrorsInt) {
		this.errors = lstErrorsInt;
	}

	public List<ErrorsInt> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorsInt> errors) {
		this.errors = errors;
	}

}
