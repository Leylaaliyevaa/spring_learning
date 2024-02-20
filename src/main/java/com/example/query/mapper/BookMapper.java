package com.example.query.mapper;

import com.example.query.dao.BookDao;
import com.example.query.dto.Dto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {


    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Dto bookDaoToDto(BookDao bookDao);

    List<Dto> bookDaosToDtos(List<BookDao> bookDaos);

    BookDao dtoToBookDao(Dto dto);
}