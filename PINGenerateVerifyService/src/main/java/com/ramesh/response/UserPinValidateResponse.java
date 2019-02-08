package com.ramesh.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="response")
@JsonTypeName("response")
//@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class UserPinValidateResponse {

	@JacksonXmlProperty(localName="result_code")
	@JsonProperty(value="result_code")
	private String resultCode;
	
	@JacksonXmlProperty(localName="valid")
	@JsonProperty(value="valid")
	private String valid;

	
	public UserPinValidateResponse() {
		
	}
	
	public UserPinValidateResponse(String resultCode, String valid) {
		super();
		this.resultCode = resultCode;
		this.valid = valid;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}
	
	
}
