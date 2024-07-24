package com.bnpp.bookstore.dao.adapter;

import com.bnpp.bookstore.DTO.BookDto;
import com.bnpp.bookstore.dao.BookDao;
import com.bnpp.bookstore.mapper.BookMapper;
import com.bnpp.bookstore.repository.BookRepository;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookDaoAdapter implements BookDao {
  @Autowired
  BookRepository bookRepository;

  @Autowired
  BookMapper bookMapper;

  @Override
  public List<BookDto> findBooksWithPagination(Pageable page) {
    var books = bookRepository.findAll(page);
    return bookMapper.toDtoList(books.getContent());
  }

  @Override
  public List<BookDto> findByTitle(String title, Pageable pageable) {
    var books = bookRepository.findByTitle(
      StringUtils.defaultIfBlank('%' + title + '%', ""),
      pageable
    );
    return bookMapper.toDtoList(books.getContent());
  }
}
