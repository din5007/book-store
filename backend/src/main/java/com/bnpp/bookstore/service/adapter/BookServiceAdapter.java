package com.bnpp.bookstore.service.adapter;

import com.bnpp.bookstore.DTO.BookDto;
import com.bnpp.bookstore.dao.BookDao;
import com.bnpp.bookstore.service.BookService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookServiceAdapter implements BookService {
  @Autowired
  BookDao bookDao;

  private static final int pageSize = 8;

  @Override
  public List<BookDto> getAllBooks(String title, Integer page) {
    Pageable pageable = PageRequest.of(page, pageSize);
    return bookDao.findByTitle(title, pageable);
  }
}
