package com.example.query.service;

import com.example.query.dao.AuthorDao;
import com.example.query.dao.BookDao;
import com.example.query.dto.AuthorDto;
import com.example.query.dto.Dto;
import com.example.query.mapper.AuthorMapper;
import com.example.query.mapper.BookMapper;
import com.example.query.repository.AuthorRepository;
import com.example.query.repository.Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final Repository repository;
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private final BookMapper bookMapper = BookMapper.INSTANCE;
    public void create(Dto dto) {
        log.info("Creating a new book: {}", dto.getTitle());
        BookDao bookDao = bookMapper.dtoToBookDao(dto);
        BookDao savedBook = repository.save(bookDao);
        bookMapper.bookDaoToDto(savedBook);
    }

    public List<Dto> readAll() {
        log.info("Reading all books");
        List<BookDao> all = repository.findAll();
        return all.stream()
                .map(bookMapper::bookDaoToDto)
                .collect(Collectors.toList());
    }

    public Dto readByID(Long id) {
        log.info("Reading book by ID: {}", id);
        BookDao bookDao = repository.findById(id).orElse(null);
        if (bookDao != null) {
            return bookMapper.bookDaoToDto(bookDao);
        }
        return null;
    }


    public void createAuthor(AuthorDto authorDto) {
        AuthorDao authorDao = authorMapper.authorDtoToAuthorDao(authorDto);
        AuthorDao savedAuthor = authorRepository.save(authorDao);
        authorMapper.authorDaoToAuthorDto(savedAuthor);
    }

    public void delete(Long id) {
        log.info("Deleting book with ID: {}", id);
        repository.deleteById(id);
    }
}
//    public Dto update(Dto dto, Long id) {
//        log.info("Updating book with ID: {}", id);
//        BookDao bookDao = repository.findById(id).orElse(null);
//        if (bookDao != null) {
//            bookDao.setTitle(dto.getTitle());
//            bookDao.setAuthor(dto.getAuthor());
//            bookDao.setPublicationYear(dto.getPublicationYear());
//            bookDao.setPrice(dto.getPrice());
//            BookDao savedBook = repository.save(bookDao);
//            return bookMapper.bookDaoToDto(savedBook);
//        }
//        return null;
//    }