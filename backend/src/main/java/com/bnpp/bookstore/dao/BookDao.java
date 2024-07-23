package com.bnpp.bookstore.dao;

import com.bnpp.bookstore.DTO.BookDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookDao {
  List<BookDto> findBooksWithPagination(Pageable page);
}
