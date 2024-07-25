package com.bnpp.bookstore.dao.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.repository.CartRepository;
import org.junit.jupiter.api.Assertions;
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
class CartDaoAdapterTest {
  @Autowired
  private CartDaoAdapter cartDaoAdapter;

  @Autowired
  private CartRepository cartRepository;

  @Test
  @Sql(scripts = { "classpath:/init-db/cart.sql" })
  void addToUserCart() {
    cartDaoAdapter.addToUserCart(1L, getUserDto());
    var cart = cartRepository.findByBookIdAndUserName(1L, "dine");
    assertEquals(4, cart.getQuantity());
  }

  @Test
  @Sql(scripts = { "classpath:/init-db/cart.sql" })
  void getUserCart() {
    var cart = cartDaoAdapter.getUserCart(getUserDto());
    assertEquals(3, cart.getCartDtoList().size());
  }

  private static UserDto getUserDto() {
    return new UserDto("dine@gmail.com", "dine", "password");
  }

  @Test
  @Sql(scripts = { "classpath:/init-db/cart.sql" })
  void decrementQuantity() {
    cartDaoAdapter.decrementQuantity(1L, getUserDto());
    var cart = cartRepository.findByBookIdAndUserName(1L, "dine");
    assertEquals(2, cart.getQuantity());
  }

  @Test
  @Sql(scripts = { "classpath:/init-db/cart.sql" })
  void removeFromUserCart() {
    cartDaoAdapter.removeFromUserCartByUser(getUserDto());
    var cart = cartDaoAdapter.getUserCart(getUserDto());
    assertEquals(0, cart.getCartDtoList().size());
  }
}
