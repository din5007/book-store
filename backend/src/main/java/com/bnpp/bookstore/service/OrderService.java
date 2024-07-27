package com.bnpp.bookstore.service;

import com.bnpp.bookstore.DTO.OrderDto;
import java.util.List;

public interface OrderService {
  boolean createOrder();

  List<OrderDto> getOrders();
}
