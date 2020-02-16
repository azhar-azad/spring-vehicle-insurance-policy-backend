package com.azad.practice.springmysqlbackend.service;

import java.util.List;

import com.azad.practice.springmysqlbackend.shared.dto.PolicyDto;

public interface PolicyService {

	PolicyDto createPolicy(PolicyDto policyDto);

	PolicyDto getPolicyByPolicyId(String policyId);

	PolicyDto updatePolicy(String policyId, PolicyDto policyDto);

	void deletePolicy(String policyId);

	List<PolicyDto> getAllPolicy(int page, int limit);
	
}
