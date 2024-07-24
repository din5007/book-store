package com.bnpp.bookstore.dao.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ComponentScan("com.bnpp.bookstore")
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class BookDaoAdapterTest {
  @Autowired
  private BookDaoAdapter bookDaoAdapter;

  @Test
  @Sql(scripts = { "classpath:/init-db/books.sql" })
  void findBooksWithPagination() {
    var books = bookDaoAdapter.findBooksWithPagination(Pageable.ofSize(5));
    assertEquals(5, books.size());
  }

  @Test
  @Sql(scripts = { "classpath:/init-db/books.sql" })
  void findBooksByTitleWithPagination() {
    var books = bookDaoAdapter.findByTitle("harry potter", Pageable.ofSize(5));
    assertEquals(5, books.size());
  }

  @Test
  @Sql(scripts = { "classpath:/init-db/books.sql" })
  void findBooksByUnknownTitleWithPagination() {
    var books = bookDaoAdapter.findByTitle("mughal", Pageable.ofSize(5));
    assertEquals(0, books.size());
  }

  @Test
  @Sql(scripts = { "classpath:/init-db/books.sql" })
  void findBooksByEmptyTitleWithPagination() {
    var books = bookDaoAdapter.findByTitle("", Pageable.ofSize(5));
    assertEquals(5, books.size());
  }
}
