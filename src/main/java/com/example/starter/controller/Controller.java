package com.example.starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class Controller {

	@GetMapping("admin")
	public String publicApi(){
		return "admin";
	}
	
	@GetMapping("/for/all")
	public String entryPoint(){
		return "public end point";
	}
	
}
