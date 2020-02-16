package com.azad.practice.springmysqlbackend.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azad.practice.springmysqlbackend.exception.PolicyServiceException;
import com.azad.practice.springmysqlbackend.io.entity.PolicyEntity;
import com.azad.practice.springmysqlbackend.io.repository.PolicyRepository;
import com.azad.practice.springmysqlbackend.service.PolicyService;
import com.azad.practice.springmysqlbackend.shared.dto.PolicyDto;
import com.azad.practice.springmysqlbackend.shared.utils.Utils;
import com.azad.practice.springmysqlbackend.ui.model.response.ErrorMessages;

@Service
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	Utils utils;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public PolicyDto createPolicy(PolicyDto policyDto) {
		
		PolicyEntity policyEntity = modelMapper.map(policyDto, PolicyEntity.class);
		
		if (policyEntity.getNumber() == "") {
			throw new PolicyServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage() + " : Policy Number");
		}
		
		if (policyEntity.getAmount() == "") {
			throw new PolicyServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage() + " : Policy Amount");
		}
		
		policyEntity.setPolicyId(utils.generatePolicyId(10));
		PolicyEntity createdPolicy = policyRepository.save(policyEntity);
		
		PolicyDto returnValue = modelMapper.map(createdPolicy, PolicyDto.class);
		return returnValue;
	}

	@Override
	public PolicyDto getPolicyByPolicyId(String policyId) {
		
		PolicyEntity policyEntity = policyRepository.findByPolicyId(policyId);
		
		if (policyEntity == null) {
			throw new PolicyServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		PolicyDto returnValue = modelMapper.map(policyEntity, PolicyDto.class);
		return returnValue;
	}

	@Override
	public PolicyDto updatePolicy(String policyId, PolicyDto policyDto) {
		
		if (policyDto.getNumber() == "") {
			throw new PolicyServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage() + " : Policy Number");
		}
		
		if (policyDto.getAmount() == "") {
			throw new PolicyServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage() + " : Policy Amount");
		}
		
		PolicyEntity policyEntity = policyRepository.findByPolicyId(policyId);
		
		if (policyEntity == null) {
			throw new PolicyServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		policyEntity.setNumber(policyDto.getNumber());
		policyEntity.setAmount(policyDto.getAmount());
		PolicyEntity updatedPolicy = policyRepository.save(policyEntity);
		
		PolicyDto returnValue = modelMapper.map(updatedPolicy, PolicyDto.class);
		return returnValue;
	}

	@Override
	public void deletePolicy(String policyId) {
		
		PolicyEntity policyEntity = policyRepository.findByPolicyId(policyId);

		if (policyEntity == null) {
			throw new PolicyServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		policyRepository.delete(policyEntity);
	}

}
