package com.bnpp.bookstore.dao.adapter;

import static org.junit.jupiter.api.Assertions.*;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ComponentScan("com.bnpp.bookstore")
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserDaoAdapterTest {
  @Autowired
  UserDaoAdapter userDaoAdapter;

  @Autowired
  UserRepository userRepository;

  @BeforeEach
  void init() {
    userRepository.deleteAll();
  }

  @Test
  void addUser() {
    var user = userRepository.findByEmail("email");
    assertNull(user);
    UserDto userDto = new UserDto();
    userDto.setUserName("userName");
    userDto.setEmail("email");
    userDto.setPassword("password");
    userDaoAdapter.addUser(userDto);
    var savedUser = userRepository.findByEmail("email");
    assertNotNull(savedUser);
  }

  @Test
  void isUserExist_withUserInDb_shouldReturnTrue() {
    UserDto userDto = new UserDto();
    userDto.setEmail("dine@gmail.com");
    userDto.setUserName("dine");
    userDto.setPassword("password");
    userDaoAdapter.addUser(userDto);
    var userExist = userDaoAdapter.isUserExist(userDto);
    assertTrue(userExist);
  }

  @Test
  void isUserExist_withoutUserInDb_shouldReturnFalse() {
    UserDto userDto = new UserDto();
    userDto.setEmail("dines");
    var userDontExist = userDaoAdapter.isUserExist(userDto);
    assertFalse(userDontExist);
  }

  @Test
  void findUserByEmail() {
    UserDto userDto = new UserDto();
    userDto.setEmail("dine@gmail.com");
    userDto.setUserName("dine");
    userDto.setPassword("password");
    userDaoAdapter.addUser(userDto);
    var user = userDaoAdapter.findUserByEmail("dine@gmail.com");
    assertNotNull(user);
    assertEquals("dine@gmail.com", user.getEmail());
    assertEquals("password", user.getPassword());
  }
}
