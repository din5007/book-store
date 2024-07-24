package com.bnpp.bookstore.service.adapter;

import com.bnpp.bookstore.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceAdapterTest {
  @Mock
  BookDao bookDao;

  @InjectMocks
  private BookServiceAdapter bookServiceAdapter;

  @Test
  void getAllBooks() {
    bookServiceAdapter.getAllBooks();
    Mockito.verify(bookDao).findBooksWithPagination(Mockito.any());
  }
}
