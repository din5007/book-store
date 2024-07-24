package com.bnpp.bookstore.dao;

import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.entities.Order;
import org.springframework.stereotype.Service;

public interface OrderDao {
  void createOrder(UserDto userDto, CartDtoList cart);
}
