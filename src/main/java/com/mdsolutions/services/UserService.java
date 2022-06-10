package com.mdsolutions.services;

import java.util.List;

import com.mdsolutions.dto.UserDto;
import com.mdsolutions.exception.UserException;

public interface UserService {

	public UserDto getUser(Integer userId)  throws UserException ;
	
	public List<UserDto> getUsers();
	
	public UserDto createUser(UserDto userDto);

	public void deleteUser(Integer userId);
	
}
