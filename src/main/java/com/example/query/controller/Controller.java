package com.example.query.controller;

import com.example.query.dto.AuthorDto;
import com.example.query.dto.Dto;
import com.example.query.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor


public class Controller {
    final BookService bookService;
    @PostMapping("createAuthor")
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        bookService.createAuthor(authorDto);
        return authorDto;
    }

    @PostMapping("/")
    public String hello() {
        return "\tWelcome to Book Center!";
    }

    @PostMapping("create")
    public Dto create(@RequestBody Dto dto) {
        bookService.create(dto);
        return dto;
    }

    @GetMapping("readAll")
    public List<Dto> readBooks() {
        return bookService.readAll();
    }

    @GetMapping("readById")
    public Dto readByID(@RequestParam Long id) {
        return bookService.readByID(id);
    }



    @DeleteMapping("delete")
    public String delete(@RequestParam Long id) {
        bookService.delete(id);
        return HttpStatus.OK.name();
    }
}
//    @PutMapping("update")
//    public Dto update(@RequestBody Dto dto, @RequestParam Long id) {
//        return service.update(dto, id);
//    }