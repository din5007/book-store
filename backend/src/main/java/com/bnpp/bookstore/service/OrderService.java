package com.bnpp.bookstore.service;

import com.bnpp.bookstore.entities.Order;
import java.util.List;

public interface OrderService {
  List<Order> getAllOrders();

  boolean createOrder();
}
