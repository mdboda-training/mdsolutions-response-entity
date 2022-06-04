package com.mdsolutions.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.mdsolutions.bo.UserDAO;
import com.mdsolutions.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mappings({ @Mapping(target = "userId", source = "userDto.userId"),
			@Mapping(target = "firstName", source = "userDto.firstName") })
	UserDAO dtoToDAO(UserDto userDto);

	@Mappings({ @Mapping(target = "userId", source = "userDAO.userId"),
		@Mapping(target = "firstName", source = "userDAO.firstName") })
	UserDto daoToDto(UserDAO userDAO);

	List<UserDAO> dtoToDAOList(List<UserDto> userDto);

	List<UserDto> daoToDtoList(List<UserDAO> userDAO);
}
