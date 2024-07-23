package com.bnpp.bookstore.service.adapter;

import com.bnpp.bookstore.DTO.BookDto;
import com.bnpp.bookstore.dao.BookDao;
import com.bnpp.bookstore.service.BookService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookServiceAdapter implements BookService {
  @Autowired
  BookDao bookDao;

  public List<BookDto> getAllBooks() {
    return bookDao.findBooksWithPagination(Pageable.ofSize(5));
  }
}
