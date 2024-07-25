package com.bnpp.bookstore.entities;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "books", indexes = {
        @Index(name = "idx_book_title", columnList = "title")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
  @Id
  @SequenceGenerator(
    name = "book_id_seq",
    sequenceName = "book_id_seq",
    allocationSize = 1
  )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "author")
  private String author;

  @Column(name = "price")
  private Double price;

  @Column(name = "quantity")
  private int quantity;
}
