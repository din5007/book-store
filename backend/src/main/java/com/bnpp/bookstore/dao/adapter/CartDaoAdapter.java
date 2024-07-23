package com.bnpp.bookstore.dao.adapter;

import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.core.exceptionHandling.NotFoundException;
import com.bnpp.bookstore.dao.CartDao;
import com.bnpp.bookstore.entities.Cart;
import com.bnpp.bookstore.mapper.CartMapper;
import com.bnpp.bookstore.repository.BookRepository;
import com.bnpp.bookstore.repository.CartRepository;
import com.bnpp.bookstore.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CartDaoAdapter implements CartDao {
  @Autowired
  CartMapper cartMapper;

  @Autowired
  UserRepository userRepository;

  @Autowired
  BookRepository bookRepository;

  @Autowired
  CartRepository cartRepository;

  @Override
  @Transactional
  @Synchronized
  public void addToUserCart(Long bookId, UserDto userDto) {
    Cart cart = cartRepository.findByBookIdAndUserName(bookId, userDto.getUsername());
    if (cart == null) {
      var user = userRepository.findByEmail(userDto.getEmail());
      var book = bookRepository
        .findById(bookId)
        .orElseThrow(() -> new NotFoundException("No Such Book Id Exist"));
      var cartEntity = new Cart();
      cartEntity.setUser(user);
      cartEntity.setBook(book);
      cartEntity.setQuantity(1);
      cartRepository.save(cartEntity);
    } else {
      cart.setQuantity(cart.getQuantity() + 1);
      cartRepository.save(cart);
    }
  }

  @Override
  public CartDtoList getUserCart(UserDto userDto) {
    var user = userRepository.findByEmail(userDto.getEmail());
    return new CartDtoList(cartMapper.toDtoList(user.getCartList()));
  }

  @Override
  @Transactional
  @Synchronized
  public void decrementQuantity(Long bookId, UserDto currentUser) {
    Cart cart = cartRepository.findByBookIdAndUserName(bookId, currentUser.getUsername());
    if (cart == null) {
      throw new NotFoundException(
        "No Such book exist in the cart for the user " + currentUser.getUsername()
      );
    } else {
      int quantity = cart.getQuantity();
      if (quantity > 1) {
        cart.setQuantity(quantity - 1);
        cartRepository.save(cart);
      } else {
        cartRepository.delete(cart);
      }
    }
  }

  @Override
  public void removeFromUserCart(UserDto userDto) {
    List<Cart> userCart = cartRepository.findByUserName(userDto.getUsername());
    cartRepository.deleteAllInBatch(userCart);
  }
}
