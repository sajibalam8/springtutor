package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.domain.Users;
import com.example.demo.dto.RequestDto;
import com.example.demo.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public String login(RequestDto dto) {

		String userName = dto.getUserName();
		String password = dto.getPassword();
		System.out.println("dtouser---------------" + userName);
		System.out.println("dtopassword---------------" + password);

		if (userName != null && password != null) {
			List<Users> list = userRepository.customFunctionTwo(userName);
			System.out.println("userOptional---------------" + list.toString());

			if (!list.isEmpty()) {
				Users user = list.get(0);
				System.out.println("User---------------" + user);
				if (userName.equalsIgnoreCase(user.getUserName()) && password.equals(user.getPassword())) {

					return "Login Successful";
				}
			}
		}

		return "Login Error";

	}

	public List<Users> findByUserName(String userName) {

		List<Users> list = userRepository.customFunctionTwo(userName);

		if (!list.isEmpty()) {

			return list;
		}

		return null;

	}

	@Transactional
	public boolean delete(String userName) {

		List<Users> list = userRepository.customFunctionTwo(userName);
		if (!list.isEmpty()) {

			Users users = list.get(0);
			userRepository.delete(users);
			return true;
		}
		return false;

	}

	public List<Users> showUsers ( ) {

		List<Users> list=userRepository.customFunctionOne();
		
			
			return list;
		
		

	}

	@Transactional
	public boolean register(RequestDto dto) {

		Users user = new Users();
		user.setUserName(dto.getUserName());
		user.setPassword(dto.getPassword());
		try {
			userRepository.save(user);

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;

	}

}
