package net.demo.ems.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "responseCode", "response" })
public class ServiceResponse {
	private String responseCode;
	private ServiceResponseIn response;

	public ServiceResponse(String responseCode, Object payload, Errors errors) {
		this.responseCode = responseCode;
		this.response = new ServiceResponseIn(payload, errors);
	}

	public class ServiceResponseIn {
		private Object payload;
		private Object error;

		public ServiceResponseIn(Object payload, Object error) {
			this.payload = payload;
			if (payload == null) {
				this.payload = new NullResponse();
			}
			this.error = error;
			if (error == null) {
				this.error = new NullResponse();
			}
		}

		public Object getPayload() {
			return payload;
		}

		public void setPayload(Object payload) {
			this.payload = payload;
		}

		public Object getError() {
			return error;
		}

		public void setError(Object error) {
			this.error = error;
		}
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public ServiceResponseIn getResponse() {
		return response;
	}

	public void setResponse(ServiceResponseIn response) {
		this.response = response;
	}

}
