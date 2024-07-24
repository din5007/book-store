package com.bnpp.bookstore.repository;

import com.bnpp.bookstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  User findByUserName(String userName);
  User findByEmail(String email);
}
