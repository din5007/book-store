package com.bnpp.bookstore.dao;

import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.OrderDto;
import com.bnpp.bookstore.DTO.UserDto;
import java.util.List;

public interface OrderDao {
  boolean createOrder(UserDto userDto, CartDtoList cart);

  List<OrderDto> getOrder(String email);
}
