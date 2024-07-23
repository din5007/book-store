package com.bnpp.bookstore.service.adapter;

import static org.junit.jupiter.api.Assertions.*;

import com.bnpp.bookstore.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
class BookServiceAdapterTest {
  @Mock
  BookDao bookDao;

  @InjectMocks
  private BookServiceAdapter bookServiceAdapter;

  @Test
  void getAllBooks() {
    bookServiceAdapter.getAllBooks();
    Mockito.verify(bookDao).findAllBooks(Mockito.any());
  }
}
