package com.example.query.ControllerTest;


import com.example.query.controller.Controller;
import com.example.query.dto.AuthorDto;
import com.example.query.dto.Dto;
import com.example.query.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
     Controller controller;

    @Mock
    BookService bookService;


    @Test
    void testReadBooks() {
        List<Dto> dtos = new ArrayList<>();
        dtos.add(new Dto());

        when(bookService.readAll()).thenReturn(dtos);

        List<Dto> result = controller.readBooks();

        verify(bookService, times(1)).readAll();

        assertEquals(dtos, result);
    }

    @Test
    void testReadByID() {

        Long id = 1L;
        Dto dto = new Dto();
        dto.setTitle("Sample Book");

        when(bookService.readByID(id)).thenReturn(dto);

        Dto result = controller.readByID(id);

        verify(bookService, times(1)).readByID(id);

        assertEquals(dto, result);
    }

}

