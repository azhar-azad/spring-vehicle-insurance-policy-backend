package com.azad.practice.springmysqlbackend.ui.model.response;

public class PolicyRest {

	private String policyId;
	private String number;
	private String amount;

	protected PolicyRest() {
		super();
	}

	public PolicyRest(String policyId, String number, String amount) {
		super();
		this.policyId = policyId;
		this.number = number;
		this.amount = amount;
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
