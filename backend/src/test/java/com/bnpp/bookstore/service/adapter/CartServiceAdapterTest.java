package com.bnpp.bookstore.service.adapter;

import static org.junit.jupiter.api.Assertions.*;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.dao.CartDao;
import org.hibernate.sql.ast.tree.expression.Over;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
class CartServiceAdapterTest {
  @InjectMocks
  CartServiceAdapter cartServiceAdapter;

  @Mock
  CartDao cartDao;

  @Test
  void addToUserCart() {
    cartServiceAdapter.addToUserCart(1L, new UserDto());
    Mockito.verify(cartDao).addToUserCart(1L, new UserDto());
  }

  @Test
  void getUserCart() {
    cartServiceAdapter.getUserCart(new UserDto());
    Mockito.verify(cartDao).getUserCart(new UserDto());
  }

  @Test
  void decrementQuantity() {
    cartServiceAdapter.decrementQuantity(1L, new UserDto());
    Mockito.verify(cartDao).decrementQuantity(1L, new UserDto());
  }
}
