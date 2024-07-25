package com.bnpp.bookstore.service;

import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;

public interface CartService {
  void addToUserCart(Long bookId, UserDto currentUser);

  CartDtoList getUserCart(UserDto userDto);

  void decrementQuantity(Long bookId, UserDto userDto);

  boolean removeFromCart(Long bookId, UserDto userDto);
}
