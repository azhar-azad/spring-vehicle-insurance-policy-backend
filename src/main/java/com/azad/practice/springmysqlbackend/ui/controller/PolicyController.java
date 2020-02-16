package com.azad.practice.springmysqlbackend.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {

	@GetMapping("/policies")
	public String test() {
		return "Hello, World!!";
	}
}
