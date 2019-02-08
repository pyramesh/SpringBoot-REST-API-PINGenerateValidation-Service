package com.ramesh.service;

import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.ramesh.controller.PinGenerateValidateController;
import com.ramesh.domain.UserPin;
import com.ramesh.repository.PinGenerateValidateRepository;
import com.ramesh.utils.PinGenerator;

/**
 * @author Ramesh.Yaleru
 *
 */
@Service
public class PinGenerateValidateService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PinGenerateValidateService.class);
	
	@Autowired
	PinGenerateValidateRepository pinGenerateValidateRepository;

	/**
	 * @param userId
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public UserPin generateVerificatioCode(Long userId) {
		LOGGER.info("####### start PinGenerateValidateService :: generateVerificatioCode ##########" + userId);
		String pinCode = PinGenerator.generatedPin();
		UserPin pinEntity = new UserPin(userId, pinCode);

		return pinGenerateValidateRepository.save(pinEntity);

	}
	
	/**
	 * @param userId
	 * @param code
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public UserPin validateUserVerificationCode(Long userId, String code) {
		LOGGER.info("####### start PinGenerateValidateService :: validateUserVerificationCode ##########" + userId);
		return pinGenerateValidateRepository.findByUserId(userId).orElse(null);
		
		 
	}
	
}
