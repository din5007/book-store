package com.bnpp.bookstore.controller;

import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.service.CartService;
import com.bnpp.bookstore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CartController {
  @Autowired
  CartService cartService;

  @Autowired
  UserService userService;

  @PutMapping("/cart/{book_id}/add")
  private void addToUserCart(@PathVariable(name = "book_id") Long bookId) {
    cartService.addToUserCart(bookId, userService.getCurrentUser());
  }

  @PutMapping("/cart/{book_id}/decrement")
  private void decrementQuantity(@PathVariable(name = "book_id") Long bookId) {
    cartService.decrementQuantity(bookId, userService.getCurrentUser());
  }

  @DeleteMapping("/cart/{book_id}/remove")
  private ResponseEntity<Boolean> removeFromCart(
    @PathVariable(name = "book_id") Long bookId
  ) {
    return ResponseEntity.ok(
      cartService.removeFromCart(bookId, userService.getCurrentUser())
    );
  }

  @GetMapping("/cart")
  private CartDtoList getUserCart() {
    return cartService.getUserCart(userService.getCurrentUser());
  }

  @GetMapping("/cart/count")
  private int getUserCartCount() {
    return cartService.getUserCartCount(userService.getCurrentUser());
  }
}
