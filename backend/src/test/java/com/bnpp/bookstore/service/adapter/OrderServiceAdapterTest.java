package com.bnpp.bookstore.service.adapter;

import static org.junit.jupiter.api.Assertions.*;

import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.dao.CartDao;
import com.bnpp.bookstore.dao.OrderDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceAdapterTest {
  @InjectMocks
  private OrderServiceAdapter orderServiceAdapter;

  @Mock
  OrderDao orderDao;

  @Mock
  CartDao cartDao;

  @Mock
  UserServiceAdapter userServiceAdapter;

  @BeforeEach
  void setUp() {}

  @Test
  void createOrder() {
    Mockito
      .when(userServiceAdapter.getCurrentUser())
      .thenReturn(new UserDto("dine", "dine", "dine"));
    Mockito.when(cartDao.getUserCart(Mockito.any())).thenReturn(new CartDtoList());

    orderServiceAdapter.createOrder();
    Mockito.verify(orderDao).createOrder(Mockito.any(), Mockito.any());
  }
}
