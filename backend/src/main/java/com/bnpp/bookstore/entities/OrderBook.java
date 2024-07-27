package com.bnpp.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_book")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderBook {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;
}
