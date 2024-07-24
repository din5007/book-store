package com.bnpp.bookstore.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
  @Id
  @Column(name = "userName", nullable = false, unique = true)
  private String userName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "name")
  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
  private List<Cart> cartList;

  @Column(name = "createdDate")
  @CreationTimestamp
  private Instant createdAt;

  @Column(name = "upadatedDate")
  @UpdateTimestamp
  private Instant UpdateAt;
}
