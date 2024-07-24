package com.bnpp.bookstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
  private UserDto user;
  private BookDto book;
  private int quantity;
}
