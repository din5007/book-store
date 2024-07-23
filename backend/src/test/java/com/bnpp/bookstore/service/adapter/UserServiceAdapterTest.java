package com.bnpp.bookstore.service.adapter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceAdapterTest {
  @InjectMocks
  private UserServiceAdapter userServiceAdapter;

  @Mock
  UserDao userDao;

  @Mock
  PasswordEncoder passwordEncoder;

  @Mock
  SecurityContext securityContext;

  @Mock
  Authentication authentication;

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
  void getCurrentUser_withNoAuthentication_shouldReturnNUll() {
    when(securityContext.getAuthentication()).thenReturn(authentication);
    when(authentication.isAuthenticated()).thenReturn(true);
    SecurityContextHolder.setContext(securityContext);
    when(SecurityContextHolder.getContext().getAuthentication().getPrincipal())
      .thenReturn(null);
    var user = userServiceAdapter.getCurrentUser();
    assertNull(user);
  }

  @Test
  void getCurrentUser_withAuthentication_shouldReturnCurrentUser() {
    UserDto userDto = new UserDto("email", "username", "password");
    when(securityContext.getAuthentication()).thenReturn(authentication);
    when(authentication.isAuthenticated()).thenReturn(true);
    SecurityContextHolder.setContext(securityContext);
    when(SecurityContextHolder.getContext().getAuthentication().getPrincipal())
      .thenReturn(userDto);

    var user = userServiceAdapter.getCurrentUser();
    assertNotNull(user);
    assertEquals("email", user.getEmail());
    assertEquals("password", user.getPassword());
    assertEquals("username", user.getUsername());
  }

  @Test
  void loadUserByUsername() {
    userServiceAdapter.loadUserByUsername("xyz@gmail.com");
    Mockito.verify(userDao).findUserByEmail("xyz@gmail.com");
  }
}
