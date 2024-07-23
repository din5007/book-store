package com.bnpp.bookstore.controller;

import com.bnpp.bookstore.MockMvcSetup;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@WebMvcTest(controllers = OrderController.class)
@ExtendWith(SpringExtension.class)
class OrderControllerTest extends MockMvcSetup {
  @Autowired
  OrderController orderController;

  @Override
  protected Object getController() {
    return orderController;
  }
}
