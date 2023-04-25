package com.hprsense.user.service.services;

import java.util.List;

import com.hprsense.user.service.dto.UserDto;

public interface UserService {

	UserDto saveUser(UserDto user);
	
	List<UserDto> getAllUser();
	
	UserDto getUser(String userId);
	
	void deleteUser(String userId);
	
	UserDto updateUser(UserDto user);
}
