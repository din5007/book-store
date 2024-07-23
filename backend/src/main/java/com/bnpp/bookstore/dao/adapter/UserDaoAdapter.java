package com.bnpp.bookstore.dao.adapter;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.core.exceptionHandling.NotFoundException;
import com.bnpp.bookstore.dao.UserDao;
import com.bnpp.bookstore.mapper.UserMapper;
import com.bnpp.bookstore.repository.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserDaoAdapter implements UserDao {
  @Autowired
  UserMapper userMapper;

  @Autowired
  UserRepository userRepository;

  @Override
  public boolean addUser(UserDto user) {
    var userEntity = userMapper.toEntity(user);
    userRepository.save(userEntity);
    return true;
  }

  @Override
  public boolean isUserExist(UserDto user) {
    return Optional
      .ofNullable(userRepository.findByUserName(user.getUsername()))
      .isPresent();
  }

  @Override
  public UserDto findUserByEmail(String email) {
    var user = Optional
      .ofNullable(userRepository.findByEmail(email))
      .orElseThrow(() -> new NotFoundException(email + " not found"));
    return userMapper.toDto(user);
  }
}
