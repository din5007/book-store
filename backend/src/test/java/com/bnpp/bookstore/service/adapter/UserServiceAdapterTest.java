package com.bnpp.bookstore.service.adapter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceAdapterTest {
  @InjectMocks
  private UserServiceAdapter userServiceAdapter;

  @Mock
  UserDao userDao;

  @Mock
  PasswordEncoder passwordEncoder;

  @BeforeEach
  void setUp() {}

  @Test
  void createUser() {
    when(passwordEncoder.encode(any())).thenReturn("randomekeys");
    UserDto user = new UserDto();
    userServiceAdapter.createUser(user);
    user.setPassword("randomkeys");
    Mockito.verify(userDao).addUser(user);
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
