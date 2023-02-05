package com.example.javajun;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeClass {

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome!!!";
	}
}
