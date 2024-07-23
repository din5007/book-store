package com.bnpp.bookstore.controller;

import com.bnpp.bookstore.entities.Order;
import com.bnpp.bookstore.service.OrderService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
  @Autowired
  OrderService orderService;

  @GetMapping("/orders")
  private List<Order> getAllOrders() {
    return orderService.getAllOrders();
  }

  @PostMapping("/order/create")
  private void createOrder() {
    orderService.createOrder();
  }
}
