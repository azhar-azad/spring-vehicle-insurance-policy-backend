package com.azad.practice.springmysqlbackend.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azad.practice.springmysqlbackend.service.PolicyService;
import com.azad.practice.springmysqlbackend.shared.dto.PolicyDto;
import com.azad.practice.springmysqlbackend.ui.model.request.PolicyDetailsRequestModel;
import com.azad.practice.springmysqlbackend.ui.model.response.OperationStatusModel;
import com.azad.practice.springmysqlbackend.ui.model.response.PolicyRest;
import com.azad.practice.springmysqlbackend.ui.model.response.RequestOperationName;
import com.azad.practice.springmysqlbackend.ui.model.response.RequestOperationStatus;

@RestController
@RequestMapping(path = "policies")
@CrossOrigin("http://localhost:4200")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	ModelMapper modelMapper = new ModelMapper();

	@PostMapping
	public PolicyRest createPolicy(@RequestBody PolicyDetailsRequestModel policyDetails) {
		
		PolicyDto policyDto = modelMapper.map(policyDetails, PolicyDto.class);
		
		PolicyDto createdPolicy = policyService.createPolicy(policyDto);
		
		PolicyRest returnValue = modelMapper.map(createdPolicy, PolicyRest.class);
		return returnValue; 
	}
	
	@GetMapping("/{policyId}")
	public PolicyRest getPolicy(@PathVariable String policyId) {
		
		PolicyDto policyDto = policyService.getPolicyByPolicyId(policyId);
		
		PolicyRest returnValue = modelMapper.map(policyDto, PolicyRest.class);
		return returnValue; 
	}
	
	@GetMapping
	public List<PolicyRest> getAllPolicy(
    		@RequestParam(value = "page", defaultValue = "0") int page,
    		@RequestParam(value = "limit", defaultValue = "25") int limit) {
    	
    	List<PolicyDto> policyDtoList = policyService.getAllPolicy(page, limit);
    	
    	List<PolicyRest> returnValue = new ArrayList<PolicyRest>();
    	
    	for (PolicyDto policyDto: policyDtoList) {
    		PolicyRest policyRest = modelMapper.map(policyDto, PolicyRest.class);
			returnValue.add(policyRest);
		}
    	
    	return returnValue;
    }
	
	@PutMapping("/{policyId}")
	public PolicyRest updatePolicy(@PathVariable String policyId, 
			@RequestBody PolicyDetailsRequestModel policyDetails) {
		
		PolicyDto policyDto = modelMapper.map(policyDetails, PolicyDto.class);
		
		PolicyDto updatedPolicy = policyService.updatePolicy(policyId, policyDto);
		
		PolicyRest returnValue = modelMapper.map(updatedPolicy, PolicyRest.class);
		return returnValue; 
	}
	
	@DeleteMapping("/{policyId}")
	public OperationStatusModel deletePolicy(@PathVariable String policyId) {
    	
    	OperationStatusModel returnValue = new OperationStatusModel();
    	
    	returnValue.setOperationName(RequestOperationName.DELETE.name());
    	policyService.deletePolicy(policyId);
    	returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
    	
        return returnValue;
    }
}
