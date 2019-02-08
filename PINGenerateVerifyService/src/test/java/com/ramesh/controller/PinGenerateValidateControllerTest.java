package com.ramesh.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ramesh.app.PinGenerateVerifyServiceApplication;
import com.ramesh.domain.UserPin;
import com.ramesh.response.UserPinResponse;
import com.ramesh.response.UserPinValidateResponse;
import com.ramesh.service.PinGenerateValidateService;

/**
 * @author Ramesh.Yaleru
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PinGenerateVerifyServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PinGenerateValidateControllerTest {

	@Autowired
	PinGenerateValidateService pinGenerateValidateService;

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testgenerateVerificatioCode_FAIL_BAD_REQUEST() {

		UserPin userPin = new UserPin();
		HttpEntity<UserPin> entity = new HttpEntity<>(userPin, null);

		ResponseEntity<UserPinResponse> response = restTemplate.exchange(createURLWithPort("/verification_code/8749303l", port),
				HttpMethod.POST, entity, UserPinResponse.class);
		System.out.println("response Code #############" + response.getStatusCode());
		assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));

	}

		
	@Test
	public void testgenerateVerificatioCode_SUCCESS() {

		UserPin userPin = new UserPin();
		HttpEntity<UserPin> entity = new HttpEntity<>(userPin, null);

		ResponseEntity<UserPinResponse> response = restTemplate.exchange(
				createURLWithPort("/verification_code/8749305", port), HttpMethod.POST, entity, UserPinResponse.class);
		System.out.println("response Code #############" + response.getStatusCode());
		assertThat(response.getBody().getMessage(), is("successful"));

	}

	@Test
	public void testValidateUserVerificationCode_SUCCESS() {

		UserPin userPin = new UserPin();
		HttpEntity<UserPin> entity = new HttpEntity<>(userPin, null);

		ResponseEntity<UserPinValidateResponse> response = restTemplate.exchange(
				createURLWithPort("/verification_code/8749305/e6f8sx", port), HttpMethod.GET, entity, UserPinValidateResponse.class);
		System.out.println("response Code #############" + response.getStatusCode());
		assertThat(response.getBody().getValid(), is("true"));

	}
	
	@Test
	public void testValidateUserVerificationCode_FAIL_WRONG_USERID() {

		UserPin userPin = new UserPin();
		HttpEntity<UserPin> entity = new HttpEntity<>(userPin, null);

		ResponseEntity<UserPinValidateResponse> response = restTemplate.exchange(
				createURLWithPort("/verification_code/8749375/e6f8sx", port), HttpMethod.GET, entity, UserPinValidateResponse.class);
		System.out.println("response Code #############" + response.getStatusCode());
		assertThat(response.getBody().getValid(), is("false"));

	}
	
	@Test
	public void testValidateUserVerificationCode_FAIL_WRONG_PIN() {

		UserPin userPin = new UserPin();
		HttpEntity<UserPin> entity = new HttpEntity<>(userPin, null);

		ResponseEntity<UserPinValidateResponse> response = restTemplate.exchange(
				createURLWithPort("/verification_code/8749305/e6f8sx1", port), HttpMethod.GET, entity, UserPinValidateResponse.class);
		System.out.println("response Code #############" + response.getStatusCode());
		assertThat(response.getBody().getValid(), is("false"));

	}
	
	
	
	
	public static String createURLWithPort(String uri, int port) {
		return "http://localhost:" + port + uri;
	}

}
