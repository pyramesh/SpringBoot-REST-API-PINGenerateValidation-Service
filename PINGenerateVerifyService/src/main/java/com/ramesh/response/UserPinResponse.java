package com.ramesh.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author Ramesh.Yaleru
 *
 */
@JacksonXmlRootElement(localName="response")
@JsonTypeName(value = "response")
//@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class UserPinResponse {
	

	@JacksonXmlProperty(localName="result_code")
	@JsonProperty(value="result_code")
	private String resultCode;
	
	@JacksonXmlProperty(localName="message")
	@JsonProperty(value="message")
	private String message;

	
	public UserPinResponse() {
		
	}


	public UserPinResponse(String resultCode, String message) {
		super();
		this.resultCode = resultCode;
		this.message = message;
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
