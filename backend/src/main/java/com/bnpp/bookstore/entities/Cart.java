package com.bnpp.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
  name = "cart"
  //  uniqueConstraints = { @UniqueConstraint(columnNames = { "userName", "book_id" }) }
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
