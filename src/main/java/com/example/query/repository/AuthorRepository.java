package com.example.query.repository;

import com.example.query.dao.AuthorDao;
import com.example.query.dao.BookDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Repository
public interface AuthorRepository extends CrudRepository<AuthorDao, Long> {
    Iterable<AuthorDao> findAll();
    @Query(value = "SELECT * FROM AuthorDao WHERE id = :id", nativeQuery = true)
    AuthorDao findWithQueryAuthor(@Param("id") long id);
}