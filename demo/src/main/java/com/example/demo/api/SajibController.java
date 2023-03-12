package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RequestDto;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/v1")
public class SajibController {
	//@Autowired
	private UserService userService;

	public SajibController(@Autowired 
			UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(value = "/welcomeToSpring")
	public String welcomeToSpring() {
		return "Hello Sajib Welcome to Spring Boot";

	}

	/*
	 * @GetMapping(value="/addition") public int
	 * addition(@RequestParam(value="a")int a) { return a;
	 * 
	 * }
	 */
	@GetMapping(value = "/addition")
	public int addition(@RequestParam(value = "a") int a, @RequestParam(value = "b", required = false) int b) {
		return a + b;

	}

	@GetMapping(value = "/concatenation")
	public String concatenation(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b) {
		return a + b;

	}

	@PostMapping(value = "/login")
	public String login(@Validated @RequestBody RequestDto dto) {
		return userService.login(dto);
	}

}
