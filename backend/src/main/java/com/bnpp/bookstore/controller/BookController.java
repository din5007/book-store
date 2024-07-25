package com.bnpp.bookstore.controller;

import com.bnpp.bookstore.DTO.BookDto;
import com.bnpp.bookstore.entities.Book;
import com.bnpp.bookstore.service.BookService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BookController {
  @Autowired
  BookService bookService;

  @GetMapping("/books")
  private List<BookDto> getAllBooks(
    @RequestParam(required = false) String title,
    @RequestParam(defaultValue = "0") Integer page
  ) {
    return bookService.getAllBooks(title, page);
  }
}
