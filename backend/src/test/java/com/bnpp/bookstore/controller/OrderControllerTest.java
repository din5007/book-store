package com.bnpp.bookstore.controller;

import com.bnpp.bookstore.MockMvcSetup;
import com.bnpp.bookstore.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = OrderController.class)
@ExtendWith(SpringExtension.class)
class OrderControllerTest extends MockMvcSetup {
  @Autowired
  OrderController orderController;

  @MockBean
  OrderService orderService;

  @Override
  protected Object getController() {
    return orderController;
  }

  @Test
  void createOrder_shouldReturn200() throws Exception {
    mvc
      .perform(
        MockMvcRequestBuilders.post("/api/order/create").contentType("application/json")
      )
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
}
