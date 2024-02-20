package com.example.query.mapper;

import com.example.query.dao.AuthorDao;
import com.example.query.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto authorDaoToAuthorDto(AuthorDao authorDao);

    AuthorDao authorDtoToAuthorDao(AuthorDto authorDto);
}
