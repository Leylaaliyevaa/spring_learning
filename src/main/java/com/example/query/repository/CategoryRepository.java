package com.example.query.repository;

import com.example.query.dao.BookDao;
import com.example.query.dao.CategoryDao;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Repository
public interface CategoryRepository extends CrudRepository<CategoryDao, Long> {
    Iterable<CategoryDao> findAll();
}