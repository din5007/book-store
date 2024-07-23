package com.bnpp.bookstore.dao.adapter;

import static org.junit.jupiter.api.Assertions.*;

import com.bnpp.bookstore.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ComponentScan("com.bnpp.bookstore")
@ActiveProfiles("test")
class BookDaoAdapterTest {

  @Autowired
  private BookDaoAdapter bookDaoAdapter;

  @Test
  @Sql(scripts = { "classpath:/init-db/books.sql"})
  void findBooksWithPagination() {
    var books = bookDaoAdapter.findBooksWithPagination(Pageable.ofSize(5));
    assertEquals(5, books.size());
  }
}
