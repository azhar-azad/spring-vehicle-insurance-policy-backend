package com.azad.practice.springmysqlbackend.shared.dto;

import java.io.Serializable;

public class PolicyDto implements Serializable {

	private static final long serialVersionUID = 1775924785718619131L;

	private Long id;
	private String policyId;
	private String number;
	private String amount;

	protected PolicyDto() {
		super();
	}

	public PolicyDto(Long id, String policyId, String number, String amount) {
		super();
		this.id = id;
		this.policyId = policyId;
		this.number = number;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
