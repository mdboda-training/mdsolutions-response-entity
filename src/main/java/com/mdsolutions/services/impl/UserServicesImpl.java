package com.mdsolutions.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mdsolutions.bo.UserDAO;
import com.mdsolutions.dto.UserDto;
import com.mdsolutions.repository.UserRepository;
import com.mdsolutions.services.UserService;

@Component
public class UserServicesImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto getUser(Integer userId) {
		UserDto userDto = new UserDto();
		Optional<UserDAO> optionalUserDao = userRepository.findById(userId);
		if (!optionalUserDao.isEmpty()) {
			UserDAO userDao = optionalUserDao.get();
			userDto = new UserDto(userDao.getUserId(), userDao.getFirstName(), userDao.getLastName(),
					userDao.getEmail(), userDao.getContactNumber());
		} else {
			userDto.setMessage("User not found with id:" + userId);
		}
		return userDto;
	}

	@Override
	public List<UserDto> getUsers() {
		List<UserDAO> list = userRepository.findAll();
		List<UserDto> userDtoList = new ArrayList<>();
		for (UserDAO userDao : list) {
			userDtoList.add(new UserDto(userDao.getUserId(), userDao.getFirstName(), userDao.getLastName(),
					userDao.getEmail(), userDao.getContactNumber()));
		}
		return userDtoList;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		UserDAO userDAO = new UserDAO(userDto.getUserId(), userDto.getFirstName(), userDto.getLastName(),
				userDto.getEmail(), userDto.getContactNumber());
		userDAO = userRepository.save(userDAO);
		userDto.setUserId(userDAO.getUserId());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

}
