package com.ramesh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramesh.domain.UserPin;
import com.ramesh.response.UserPinResponse;
import com.ramesh.response.UserPinValidateResponse;
import com.ramesh.service.PinGenerateValidateService;


/**
 * @author Ramesh.Yaleru
 *
 */

@RestController
public class PinGenerateValidateController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PinGenerateValidateController.class);
	
	@Autowired
	PinGenerateValidateService pinService;
	
	
	/**
	 * @param userId
	 * @return
	 */
	@PostMapping(value="/verification_code/{user_id}", produces =
			{MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	//@ApiOperation(value = "generate Random 6 digits Verification code for the user.")
	public UserPinResponse generateVerificatioCode(@PathVariable (value="user_id") Long userId) {
		LOGGER.info("####### start PinGenerateValidateController :: generateVerificatioCode ##########" + userId);
		UserPinResponse pinRespone =null;
		UserPin response = pinService.generateVerificatioCode(userId);
		LOGGER.info("####### response ##########" + response);
		if(response.getId() != null) {
			 pinRespone = new UserPinResponse("1", "successful");	
		}else {
			 pinRespone = new UserPinResponse("0", "error");
		}
		LOGGER.info("####### end PinGenerateValidateController :: generateVerificatioCode ##########" + pinRespone);
		return pinRespone;
	}
	
	
	/**
	 * @param userId
	 * @param code
	 * @return
	 */
	@GetMapping(value="/verification_code/{user_id}/{code}", produces =
		{MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE
		})
	//@ApiOperation(value = "validate verification code -PIN for user")
public UserPinValidateResponse validateUserVerificationCode(@PathVariable(value="user_id") Long userId, @PathVariable String code) {
		LOGGER.info("####### start PinGenerateValidateController :: validateUserVerificationCode ##########" + userId +" and code "+code);
	UserPinValidateResponse pinRespone = null;
	UserPin response = pinService.validateUserVerificationCode(userId, code);
	if(response != null && response.getVerificatioCode().equals(code)) {
		 pinRespone = new UserPinValidateResponse("1", "true");	
	}else {
		 pinRespone = new UserPinValidateResponse("1", "false");
	}
	LOGGER.info("####### end PinGenerateValidateController :: validateUserVerificationCode ##########");	
	return pinRespone;

}
	
	
}
