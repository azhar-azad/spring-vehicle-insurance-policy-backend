package com.azad.practice.springmysqlbackend.ui.model.request;

public class PolicyDetailsRequestModel {

	private String number;
	private String amount;

	protected PolicyDetailsRequestModel() {
		super();
	}

	public PolicyDetailsRequestModel(String number, String amount) {
		super();
		this.number = number;
		this.amount = amount;
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
