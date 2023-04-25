package com.hprsense.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hprsense.user.service.dto.UserDto;
import com.hprsense.user.service.services.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("save")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}
	
	@GetMapping("all")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable String userId){
		return ResponseEntity.ok(userService.getUser(userId));
	}
}
