package com.bnpp.bookstore.repository;

import com.bnpp.bookstore.DTO.OrderDto;
import com.bnpp.bookstore.entities.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
  List<Order> findByUserName(String userName);
}
