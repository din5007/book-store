package com.bnpp.bookstore.controller;

import com.bnpp.bookstore.entities.Order;
import com.bnpp.bookstore.service.OrderService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderController {
  @Autowired
  OrderService orderService;

  @PostMapping("/order/create")
  private ResponseEntity<Boolean> createOrder() {
    try {
      return ResponseEntity.ok(orderService.createOrder());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(false);
    }
  }
}
