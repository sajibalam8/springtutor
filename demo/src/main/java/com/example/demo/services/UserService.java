package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.RequestDto;

@Service
public class UserService {

	
	public String login( RequestDto dto) {
		
		String userName = dto.getUserName();
		String password = dto.getPassword();
	
		if ((userName).equals("Sajib") && password.equals("admin")) {
			return"Login Successful";
		}
		else {
				
			return"Login Error";	
			}
		}

}
