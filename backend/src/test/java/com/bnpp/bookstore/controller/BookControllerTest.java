package com.bnpp.bookstore.controller;

import com.bnpp.bookstore.MockMvcSetup;
import com.bnpp.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = BookController.class)
@ExtendWith(SpringExtension.class)
class BookControllerTest extends MockMvcSetup {
  @Autowired
  BookController bookController;

  @MockBean
  BookService bookService;

  @Override
  protected Object getController() {
    return bookController;
  }

  @Test
  void findAllBooks_shouldReturn200Success() throws Exception {
    mvc
      .perform(MockMvcRequestBuilders.get("/api/books"))
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
}
