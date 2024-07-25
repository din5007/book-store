package com.bnpp.bookstore.dao.adapter;

import com.bnpp.bookstore.DTO.CartDto;
import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.dao.OrderDao;
import com.bnpp.bookstore.entities.Order;
import com.bnpp.bookstore.entities.OrderBook;
import com.bnpp.bookstore.mapper.BookMapper;
import com.bnpp.bookstore.mapper.OrderMapper;
import com.bnpp.bookstore.mapper.UserMapper;
import com.bnpp.bookstore.repository.OrderRepository;
import com.bnpp.bookstore.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDaoAdapter implements OrderDao {
  @Autowired
  UserMapper userMapper;

  @Autowired
  BookMapper bookMapper;

  @Autowired
  OrderMapper orderMapper;

  @Autowired
  OrderRepository orderRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean createOrder(UserDto userDto, CartDtoList cart) {
    Order order = new Order();
    order.setUser(userRepository.findByEmail(userDto.getEmail()));
    order.setTotalQuantity(calculateTotalQuanity(cart));
    order.setTotalPrice(calculateTotalPrice(cart));
    order.setOrderBookList(orderMapper.toOrderBook(cart.getCartDtoList()));
    orderRepository.saveAndFlush(order);
    return true;
  }

  private static double calculateTotalQuanity(CartDtoList cart) {
    return cart.getCartDtoList().stream().mapToDouble(CartDto::getQuantity).sum();
  }

  private static double calculateTotalPrice(CartDtoList cart) {
    return cart
      .getCartDtoList()
      .stream()
      .mapToDouble(cartDto -> cartDto.getBook().getPrice() * cartDto.getQuantity())
      .sum();
  }
}
