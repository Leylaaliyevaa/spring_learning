package com.example.query.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.example.query.dao.UserDao;
import com.example.query.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "username")
    UserDto daoToDto(UserDao dao);

    @Mapping(source = "username", target = "email")
    UserDao dtoToDao(UserDto dto);

    List<UserDto> convertDAOListToDTOList(List<UserDao> daoList);

    List<UserDao> convertDTOListToDAOList(List<UserDto> dtoList);

}
