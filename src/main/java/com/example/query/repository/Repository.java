package com.example.query.repository;

import com.example.query.dao.BookDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<BookDao, Long> {
    ArrayList<BookDao> findAll();
    @Query("SELECT b FROM BookDao b WHERE b.price > :price")
    ArrayList<BookDao> findByPriceGreaterThan(@Param("price") int price);

    @Query(value = "SELECT * FROM BookDao WHERE price < :maxPrice", nativeQuery = true)
    List<Book> findBooksByPriceLowerThan(@Param("maxPrice") int maxPrice);
//    List<BookDao> findByAuthor(String authorName);
//
//    List<BookDao> findByCategoriesName(String categoryName);
//
//    List<BookDao> findByPriceGreaterThan(double price);
//
//    List<BookDao> findByPublicationYearAfter(int year);
//
//    List<BookDao> findByAuthorAndPriceGreaterThan(String authorName, double price);

}