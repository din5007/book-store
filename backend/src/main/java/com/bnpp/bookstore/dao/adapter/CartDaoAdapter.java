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
import java.util.Objects;
import java.util.stream.Collectors;
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
  @Transactional
  public CartDtoList getUserCart(UserDto userDto) {
    var cart = cartRepository.findByEmail(userDto.getEmail());
    return new CartDtoList(cartMapper.toDtoList(cart));
  }

  @Override
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
  public boolean removeFromUserCart(Long bookId, UserDto userDto) {
    List<Cart> userCart = cartRepository.findByUserName(userDto.getUsername());
    cartRepository.deleteAllInBatch(
      userCart
        .stream()
        .filter(cart -> Objects.equals(cart.getBook().getId(), bookId))
        .collect(Collectors.toList())
    );
    return true;
  }

  @Override
  public boolean removeFromUserCartByUser(UserDto userDto) {
    List<Cart> userCart = cartRepository.findByUserName(userDto.getUsername());
    cartRepository.deleteAllInBatch(userCart);
    return true;
  }
}
