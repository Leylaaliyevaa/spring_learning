package com.example.query.ServiceTest;

import com.example.query.dao.AuthorDao;
import com.example.query.dao.BookDao;
import com.example.query.dto.AuthorDto;
import com.example.query.dto.Dto;
import com.example.query.mapper.AuthorMapper;
import com.example.query.mapper.BookMapper;
import com.example.query.repository.AuthorRepository;
import com.example.query.repository.Repository;
import com.example.query.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookService bookService;

    @Mock
    Repository repository;

    @Mock
    AuthorRepository authorRepository;

    @Mock
    BookMapper bookMapper;

    @Mock
    AuthorMapper authorMapper;

    @Test
    void testCreate() {
        Dto dto = Dto.builder().authorId(1).title(null).author(null).publicationYear(0).price(0).build();

        BookDao bookDao = new BookDao();
        when(repository.save(bookDao)).thenReturn(bookDao);

        bookService.create(dto);

        verify(bookMapper, times(0)).dtoToBookDao(dto);
        verify(repository, times(1)).save(bookDao);

        verifyNoMoreInteractions(bookMapper);
    }

    @Test
    void testCreateAuthor() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName("John Doe");

        AuthorDao authorDao = new AuthorDao();
        authorDao.setName(authorDto.getName());

        when(authorRepository.save(authorDao)).thenReturn(authorDao);

        bookService.createAuthor(authorDto);

        verify(authorMapper, times(0)).authorDtoToAuthorDao(authorDto);

        verify(authorRepository, times(1)).save(authorDao);

        verifyNoMoreInteractions(authorMapper);
    }

}
