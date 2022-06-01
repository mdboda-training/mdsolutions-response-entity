package com.mdsolutions.services;

import java.util.List;

import com.mdsolutions.dto.UserDto;

public interface UserService {

	public UserDto getUser(Integer userId);
	
	public List<UserDto> getUsers();
	
	public UserDto createUser(UserDto userDto);

	public void deleteUser(Integer userId);
	
}
