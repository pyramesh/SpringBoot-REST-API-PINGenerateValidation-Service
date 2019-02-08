package com.ramesh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author Ramesh.Yaleru
 *
 */
@Entity
public class UserPin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotNull
	@Column(name = "user_id")
	private Long userId;
	
	@NotNull
	@Column(name = "code")
	private String verificatioCode;

	public UserPin() {

	}

	public UserPin(Long userId, String verificatioCode) {
		super();
		this.userId = userId;
		this.verificatioCode = verificatioCode;
	}




	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVerificatioCode() {
		return verificatioCode;
	}

	public void setVerificatioCode(String verificatioCode) {
		this.verificatioCode = verificatioCode;
	}

}
