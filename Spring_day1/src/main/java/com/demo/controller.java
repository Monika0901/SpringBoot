package com.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	@GetMapping("/java")
	public String myApi() {
		return "This is my java file";
		}
	
	@PostMapping("/python")
	public String SecondApi() {
		return "This is my python file";
		}
	
	@PutMapping("/html")
	public String thirdApi() {
		return "This is html file";
	}
	
	@DeleteMapping("/css")
	public String fourthApi() {
		return "This is my css file";
	}
		
	
}
