package com.bnpp.bookstore.dao;

import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface CartDao {
  void addToUserCart(Long bookId, UserDto userDto);
  CartDtoList getUserCart(UserDto userDto);

  void decrementQuantity(Long bookId, UserDto currentUser);

  void removeFromUserCart(UserDto userDto);
}
