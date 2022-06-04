package com.mdsolutions.mapper;

import com.mdsolutions.bo.UserDAO;
import com.mdsolutions.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-04T19:51:37+0530",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 11.0.15.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDAO dtoToDAO(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserDAO userDAO = new UserDAO();

        userDAO.setUserId( userDto.getUserId() );
        userDAO.setFirstName( userDto.getFirstName() );
        userDAO.setLastName( userDto.getLastName() );
        userDAO.setEmail( userDto.getEmail() );
        userDAO.setContactNumber( userDto.getContactNumber() );

        return userDAO;
    }

    @Override
    public UserDto daoToDto(UserDAO userDAO) {
        if ( userDAO == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserId( userDAO.getUserId() );
        userDto.setFirstName( userDAO.getFirstName() );
        userDto.setLastName( userDAO.getLastName() );
        userDto.setEmail( userDAO.getEmail() );
        userDto.setContactNumber( userDAO.getContactNumber() );

        return userDto;
    }

    @Override
    public List<UserDAO> dtoToDAOList(List<UserDto> userDto) {
        if ( userDto == null ) {
            return null;
        }

        List<UserDAO> list = new ArrayList<UserDAO>( userDto.size() );
        for ( UserDto userDto1 : userDto ) {
            list.add( dtoToDAO( userDto1 ) );
        }

        return list;
    }

    @Override
    public List<UserDto> daoToDtoList(List<UserDAO> userDAO) {
        if ( userDAO == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userDAO.size() );
        for ( UserDAO userDAO1 : userDAO ) {
            list.add( daoToDto( userDAO1 ) );
        }

        return list;
    }
}
