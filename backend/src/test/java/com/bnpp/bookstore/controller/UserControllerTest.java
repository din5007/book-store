package com.bnpp.bookstore.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.MockMvcSetup;
import com.bnpp.bookstore.core.exceptionHandling.AlreadyExistException;
import com.bnpp.bookstore.service.UserService;
import com.bnpp.bookstore.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(SpringExtension.class)
class UserControllerTest extends MockMvcSetup {
  @Autowired
  UserController userController;

  @MockBean
  UserService userService;

  @MockBean
  AuthenticationManager authenticationManager;

  @MockBean
  JwtUtils jwtUtils;

  @MockBean
  PasswordEncoder passwordEncoder;

  @Override
  protected Object getController() {
    return userController;
  }

  @Test
  void signup_shouldReturn200() throws Exception {
    mvc
      .perform(
        MockMvcRequestBuilders
          .post("/api/users/signup")
          .contentType("application/json")
          .content(
            objectMapper.writeValueAsString(
              new UserDto("dine@gmail.com", "dine", "password")
            )
          )
      )
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  void signup_withExistingUser_shouldReturn400() throws Exception {
    when(userService.createUser(any()))
      .thenThrow(new AlreadyExistException("User Exist"));
    mvc
      .perform(
        MockMvcRequestBuilders
          .post("/api/users/signup")
          .contentType("application/json")
          .content(
            objectMapper.writeValueAsString(
              new UserDto("dine@gmail.com", "dine", "password")
            )
          )
      )
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status().is4xxClientError());
  }
}
