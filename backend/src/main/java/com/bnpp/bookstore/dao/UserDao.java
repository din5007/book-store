package com.bnpp.bookstore.dao;

import com.bnpp.bookstore.DTO.UserDto;

public interface UserDao {
  boolean addUser(UserDto user);
  boolean isUserExist(UserDto user);

  UserDto findUserByEmail(String username);
}
