package com.bnpp.bookstore.dao.adapter;

import com.bnpp.bookstore.DTO.CartDto;
import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.dao.OrderDao;
import com.bnpp.bookstore.entities.Order;
import com.bnpp.bookstore.entities.OrderBook;
import com.bnpp.bookstore.mapper.BookMapper;
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
  OrderRepository orderRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean createOrder(UserDto userDto, CartDtoList cart) {
    Order order = new Order();
    order.setUser(userRepository.findByEmail(userDto.getEmail()));
    Double totalQuantity = cart
      .getCartDtoList()
      .stream()
      .mapToDouble(CartDto::getQuantity)
      .sum();
    order.setTotalQuantity(totalQuantity);
    Double totalPrice = cart
      .getCartDtoList()
      .stream()
      .mapToDouble(cartDto -> cartDto.getBook().getPrice() * cartDto.getQuantity())
      .sum();
    order.setTotalPrice(totalPrice);
    List<OrderBook> orderBook = cart
      .getCartDtoList()
      .stream()
      .map(
        cartDto -> {
          OrderBook orderBook1 = new OrderBook();
          orderBook1.setBook(bookMapper.toEntity(cartDto.getBook()));
          return orderBook1;
        }
      )
      .toList();
    order.setOrderBookList(orderBook);
    orderRepository.saveAndFlush(order);
    return true;
  }
}
