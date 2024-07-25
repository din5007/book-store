package com.bnpp.bookstore.dao;

import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;

public interface OrderDao {
  boolean createOrder(UserDto userDto, CartDtoList cart);
}
