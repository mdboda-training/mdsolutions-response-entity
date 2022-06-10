package com.mdsolutions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdsolutions.dto.UserDto;
import com.mdsolutions.exception.UserException;
import com.mdsolutions.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	Environment environment;

	@GetMapping("/user/getUsers")
	public ResponseEntity<UserDto> getUsers(@RequestParam Integer userId) throws UserException {
		UserDto userDto = userService.getUser(userId);
		userDto.setMessage("Port: " + environment.getProperty("server.port"));

		ResponseEntity<UserDto> response = new ResponseEntity<>(userDto, HttpStatus.OK);
		return response;
	}

	@GetMapping("/user/getAllUsers")
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> userDtoList = userService.getUsers();
		ResponseEntity<List<UserDto>> response = new ResponseEntity<>(userDtoList, HttpStatus.OK);
		return response;

	}

	@GetMapping("/user/deleteUser")
	public ResponseEntity<String> getDeleteUser(@RequestParam Integer userId) {
		userService.deleteUser(userId);
		ResponseEntity<String> response = new ResponseEntity<>("Deleted Successfully with id:" + userId, HttpStatus.OK);
		return response;
	}

	@PostMapping("/user/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		userDto = userService.createUser(userDto);
		ResponseEntity<UserDto> response = new ResponseEntity<>(userDto, HttpStatus.CREATED);
		return response;

	}

}
