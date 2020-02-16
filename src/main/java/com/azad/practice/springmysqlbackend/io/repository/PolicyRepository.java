package com.azad.practice.springmysqlbackend.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azad.practice.springmysqlbackend.io.entity.PolicyEntity;

@Repository
public interface PolicyRepository extends PagingAndSortingRepository<PolicyEntity, Long> {

	PolicyEntity findByPolicyId(String policyId);

}
