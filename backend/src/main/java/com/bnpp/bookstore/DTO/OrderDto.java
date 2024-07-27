package com.bnpp.bookstore.DTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
  private int orderId;
  private UserDto user;
  private List<BookDto> books;
  private Double totalQuantity;
  private Double totalPrice;
}
