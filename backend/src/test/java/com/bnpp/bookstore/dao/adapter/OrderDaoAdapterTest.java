package com.bnpp.bookstore.dao.adapter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bnpp.bookstore.DTO.BookDto;
import com.bnpp.bookstore.DTO.CartDto;
import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.repository.CartRepository;
import com.bnpp.bookstore.repository.OrderRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ComponentScan("com.bnpp.bookstore")
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class OrderDaoAdapterTest {
  @Autowired
  private OrderDaoAdapter orderDaoAdapter;

  @Autowired
  OrderRepository orderRepository;

  @Test
  @Sql(scripts = { "classpath:/init-db/order.sql" })
  void createOrder() {
    var cart = new CartDtoList();
    var cartDto = new CartDto();
    cartDto.setBook(getBookDto());
    cartDto.setQuantity(5);
    cartDto.setUser(getUserDto());
    cart.setCartDtoList(List.of(cartDto));
    assertTrue(orderDaoAdapter.createOrder(getUserDto(), cart));
  }

  private static UserDto getUserDto() {
    return new UserDto("dine@gmail.com", "dine", "password");
  }

  private static BookDto getBookDto() {
    return new BookDto(1L, "potter", "rowling", 49.50, 200);
  }
}
