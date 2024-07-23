package com.bnpp.bookstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
  private Long id;
  private String title;
  private String author;
  // unit price of the book
  private Double price;
  // available quantity or inventory
  private long quantity;
}
