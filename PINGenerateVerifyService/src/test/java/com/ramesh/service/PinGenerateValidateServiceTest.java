package com.ramesh.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ramesh.app.PinGenerateVerifyServiceApplication;
import com.ramesh.domain.UserPin;
import com.ramesh.repository.PinGenerateValidateRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest(classes=PinGenerateVerifyServiceApplication.class)
@SpringBootConfiguration
public class PinGenerateValidateServiceTest {
	
	@Autowired
	PinGenerateValidateService pinGenerateValidateService;
	
	@MockBean
	PinGenerateValidateRepository pinGenerateValidateRepository;
	
	@Test
	public void testvalidateUserVerificationCode() {
		
		Long inputUserId = new Long(8666302);
		
		UserPin pinEntity1 = new UserPin(inputUserId, "abd12v");
		Optional<UserPin> pinEntity = Optional.of(pinEntity1);
		
		Mockito.when(pinGenerateValidateRepository.findByUserId(inputUserId)).thenReturn(pinEntity);
		UserPin verCode = pinGenerateValidateService.validateUserVerificationCode(inputUserId, "abd12v");
		System.out.println("verfication Code "+verCode.getVerificatioCode());
		assertThat(verCode.getVerificatioCode()).isEqualTo(pinEntity1.getVerificatioCode());
		
	}
		
	
}
