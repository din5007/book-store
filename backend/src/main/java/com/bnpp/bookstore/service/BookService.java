package com.bnpp.bookstore.service;

import com.bnpp.bookstore.DTO.BookDto;
import com.bnpp.bookstore.entities.Book;
import java.util.List;

public interface BookService {
  List<BookDto> getAllBooks();
  //  BookDto findById(int id);
}
