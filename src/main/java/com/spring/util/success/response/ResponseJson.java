package com.spring.util.success.response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ResponseJson{



	private final String responseCode = "S0001";

	private String responseDescription;

	private Object response;

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getResponseCode() {
		return responseCode;
	}
	


	



	
	

}
