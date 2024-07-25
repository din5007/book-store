package com.bnpp.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
  name = "cart",
  indexes = {
    @Index(
      name = "idx_cart_user_name_unq",
      columnList = "user_name, book_id",
      unique = true
    )
  }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_name")
  private User user;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;

  private int quantity;
}
