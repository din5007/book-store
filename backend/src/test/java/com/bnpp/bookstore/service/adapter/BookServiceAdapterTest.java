package com.bnpp.bookstore.service.adapter;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

import com.bnpp.bookstore.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
    bookServiceAdapter.getAllBooks("title", 5);
    verify(bookDao).findByTitle(any(), any());
  }
}
