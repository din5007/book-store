package com.bnpp.bookstore.controller;

import com.bnpp.bookstore.MockMvcSetup;
import com.bnpp.bookstore.service.CartService;
import com.bnpp.bookstore.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = CartController.class)
@ExtendWith(SpringExtension.class)
class CartControllerTest extends MockMvcSetup {
  @Autowired
  CartController cartController;

  @MockBean
  CartService cartService;

  @MockBean
  UserService userService;

  @Override
  protected Object getController() {
    return cartController;
  }

  @Test
  void addToUserCart_withBookId_shouldReturn200() throws Exception {
    mvc
      .perform(
        MockMvcRequestBuilders.put("/api/cart/1/add").contentType("application/json")
      )
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  void removeFromUserCart_withBookId_shouldReturn200() throws Exception {
    mvc
      .perform(MockMvcRequestBuilders.put("/api/cart/1/decrement"))
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  void getUserCart_withBookId_shouldReturn200() throws Exception {
    mvc
      .perform(MockMvcRequestBuilders.get("/api/cart/"))
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
}
