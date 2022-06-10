package com.mdsolutions.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.mdsolutions.bo.UserDAO;
import com.mdsolutions.dto.UserDto;
import com.mdsolutions.exception.UserException;
import com.mdsolutions.mapper.UserMapper;
import com.mdsolutions.repository.UserRepository;
import com.mdsolutions.services.UserService;

@Component
public class UserServicesImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDto getUser(Integer userId) throws UserException { 
		UserDto userDto = new UserDto();
		Optional<UserDAO> optionalUserDao = userRepository.findById(userId);
		if (!optionalUserDao.isEmpty()) {
			userDto = userMapper.daoToDto(optionalUserDao.get());
		} else {
			throw new UserException("Resource not found "+userId, HttpStatus.NOT_FOUND);
		}
		return userDto;
	}

	@Override
	public List<UserDto> getUsers() {
		List<UserDAO> list = userRepository.findAll();
		List<UserDto> userDtoList = userMapper.daoToDtoList(list);
		return userDtoList;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		userRepository.save(userMapper.dtoToDAO(userDto));
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

}
