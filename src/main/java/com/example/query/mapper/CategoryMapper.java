package com.example.query.mapper;

import com.example.query.dao.CategoryDao;
import com.example.query.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

//    @Mapping(source = "bookDaos", target = "bookdtos")
    CategoryDto categoryDaoToDto(CategoryDao categoryDao);

    List<CategoryDto> categoryDaosToDtos(List<CategoryDao> categoryDaos);
}
