package com.bnpp.bookstore.controller;

import com.bnpp.bookstore.DTO.JwtTokenDto;
import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.service.UserService;
import com.bnpp.bookstore.service.adapter.UserServiceAdapter;
import com.bnpp.bookstore.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
  @Autowired
  UserService userService;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  PasswordEncoder passwordEncoder;

  @PostMapping("/signup")
  private void createUser(@RequestBody UserDto userDto) {
    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
    userService.createUser(userDto);
  }

  @PostMapping("/login")
  private ResponseEntity<JwtTokenDto> loginUser(@RequestBody UserDto userDto) {
    var authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword())
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    UserDto userDetails = (UserDto) authentication.getPrincipal();
    return ResponseEntity.ok(
      new JwtTokenDto(jwt, userDetails.getUsername(), userDetails.getEmail())
    );
  }
}
