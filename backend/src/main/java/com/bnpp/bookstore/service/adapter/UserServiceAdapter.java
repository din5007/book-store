package com.bnpp.bookstore.service.adapter;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.core.exceptionHandling.AlreadyExistException;
import com.bnpp.bookstore.dao.UserDao;
import com.bnpp.bookstore.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserServiceAdapter implements UserService {
  @Autowired
  UserDao userDao;

  public boolean createUser(UserDto userDto) {
    if (userDao.isUserExist(userDto)) {
      throw new AlreadyExistException("User Already Exist");
    }
    return userDao.addUser(userDto);
  }

  @Override
  public UserDto getCurrentUser() {
    var authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || !authentication.isAuthenticated()) {
      return null;
    }
    return (UserDto) authentication.getPrincipal();
  }

  @Override
  public UserDto loadUserByUsername(String email) {
    return userDao.findUserByEmail(email);
  }
}
