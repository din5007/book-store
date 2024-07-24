package com.bnpp.bookstore.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
  @Id
  @SequenceGenerator(
    name = "order_id_seq",
    sequenceName = "order_id_seq",
    allocationSize = 1
  )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
  private int orderId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userName", referencedColumnName = "userName")
  private User user;

  @Column(name = "total_price")
  private Double totalPrice;

  @Column(name = "total_quantity")
  private Double totalQuantity;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "orderId", referencedColumnName = "orderId")
  private List<OrderBook> orderBookList = new ArrayList<>();

  @Column(name = "order_date")
  @CreationTimestamp
  private Instant orderDate;
}
