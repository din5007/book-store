package com.bnpp.bookstore.service.adapter;

import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.dao.CartDao;
import com.bnpp.bookstore.service.CartService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CartServiceAdapter implements CartService {
  @Autowired
  CartDao cartDao;

  @Override
  public void addToUserCart(Long bookId, UserDto currentUser) {
    cartDao.addToUserCart(bookId, currentUser);
  }

  @Override
  public CartDtoList getUserCart(UserDto userDto) {
    return cartDao.getUserCart(userDto);
  }

  @Override
  public void decrementQuantity(Long bookId, UserDto currentUser) {
    cartDao.decrementQuantity(bookId, currentUser);
  }

  @Override
  public boolean removeFromCart(Long bookId, UserDto userDto) {
    return cartDao.removeFromUserCart(bookId, userDto);
  }
}
