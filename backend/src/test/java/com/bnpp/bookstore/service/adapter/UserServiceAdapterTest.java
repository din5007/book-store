package com.bnpp.bookstore.service.adapter;

import static org.junit.jupiter.api.Assertions.*;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceAdapterTest {
  @InjectMocks
  private UserServiceAdapter userServiceAdapter;

  @Mock
  UserDao userDao;

  @BeforeEach
  void setUp() {}

  @Test
  void createUser() {
    userServiceAdapter.createUser(new UserDto());
    Mockito.verify(userDao).addUser(new UserDto());
  }

  @Test
  void getCurrentUser() {
    userServiceAdapter.getCurrentUser();
  }

  @Test
  void loadUserByUsername() {
    userServiceAdapter.loadUserByUsername("xyz@gmail.com");
    Mockito.verify(userDao).findUserByEmail("xyz@gmail.com");
  }
}
