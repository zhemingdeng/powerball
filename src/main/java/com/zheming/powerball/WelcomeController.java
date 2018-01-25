package com.zheming.powerball;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class WelcomeController {
	
	@RequestMapping("/")
	public String hello() {
		return "Hello, this is Powerball page for Jieling and Zheming";
	}
	
	@RequestMapping("/app")
	public String test() {
		return "test for 2nd page";
	}
}
