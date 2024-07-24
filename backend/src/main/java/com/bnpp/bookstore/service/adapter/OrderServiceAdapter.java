package com.bnpp.bookstore.service.adapter;

import com.bnpp.bookstore.DTO.CartDto;
import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.dao.CartDao;
import com.bnpp.bookstore.dao.OrderDao;
import com.bnpp.bookstore.entities.Cart;
import com.bnpp.bookstore.entities.Order;
import com.bnpp.bookstore.entities.OrderBook;
import com.bnpp.bookstore.mapper.BookMapper;
import com.bnpp.bookstore.mapper.OrderMapper;
import com.bnpp.bookstore.mapper.UserMapper;
import com.bnpp.bookstore.repository.OrderRepository;
import com.bnpp.bookstore.service.OrderService;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class OrderServiceAdapter implements OrderService {
  @Autowired
  OrderRepository orderRepository;

  @Autowired
  OrderDao orderDao;

  @Autowired
  CartDao cartDao;

  @Autowired
  OrderMapper orderMapper;

  @Autowired
  BookMapper bookMapper;

  @Autowired
  UserMapper userMapper;

  @Autowired
  private UserServiceAdapter userServiceAdapter;

  public List<Order> getAllOrders() {
    List<Order> orders = new ArrayList<Order>();
    orderRepository.findAll().forEach(order -> orders.add(order));
    return orders;
  }

  @Override
  @Transactional
  public void createOrder() {
    var userDto = userServiceAdapter.getCurrentUser();
    var cart = cartDao.getUserCart(userDto);
    orderDao.createOrder(userDto, cart);
    cartDao.removeFromUserCart(userDto);
  }
}
