package com.azad.practice.springmysqlbackend.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policies")
public class PolicyEntity implements Serializable {

	private static final long serialVersionUID = 3968559867007622972L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String policyId;
	
	@Column(nullable = false)
	private String number;
	
	@Column(nullable = false)
	private String amount;

	protected PolicyEntity() {
		super();
	}

	public PolicyEntity(String policyId, String number, String amount) {
		super();
		this.policyId = policyId;
		this.number = number;
		this.amount = amount;
	}

	public Long getId() {
		return id;
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
