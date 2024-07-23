package com.bnpp.bookstore.service;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService {
  boolean createUser(UserDto user);
  UserDto getCurrentUser();
  UserDto loadUserByUsername(String username);
}
